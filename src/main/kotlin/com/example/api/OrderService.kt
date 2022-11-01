package com.example.api

import org.springframework.stereotype.Service

@Service
class OrderService(private val repository: LimitOrderRepository, private val tradeService: TradeService) {

    /*
        Save the order object (Validations are not added)
        After save, if it's not a maker order then check for counter orders
        If counter orders are present then make the trade, else the order lies in orderbook
        This is right now an inplace implementation, for prod level we will be using queues for this
     */
    fun create(order: LimitOrder): MutableMap<String, String?>{
        val generatedId = java.util.UUID.randomUUID().toString()
        order.uniqueId = generatedId
        /*
            1. Keep a check to see if the generatedId is unique before assigning it to order object
            2. Add user based checks here to validate: user's balance & user's permissions
            3. If customerOrderId is provided Add check to see if an open order exists with the same id
         */
        val order = repository.save(order)
        /*
            make trade if counter order is present; only in the case when it's not a maker order
            right now it will match the order with the same user's counter order too, this can be handled as well
         */
        if(!order.postOnly){
            val counterOrders: List<LimitOrder> = if(order.side == "buy") {
                repository.findByPairAndSideAndStateOrderByPriceAsc(order.pair, "sell")
            } else {
                repository.findByPairAndSideAndStateOrderByPriceDesc(order.pair, "buy")
            }
            if(counterOrders.isNotEmpty()){
                val counterOrder = counterOrders[0]
                /*
                    Match the current order with the counter order
                    Right now we are not considering the case of partial matching to make the matching simple
                    Also error handling can be further added here
                 */
                tradeService.createTrade(counterOrder, order)
                counterOrder.state = "executed"
                order.state = "executed"
                repository.save(counterOrder)
                repository.save(order)
            }
        }

//      create response
        val map: MutableMap<String, String?> = mutableMapOf()
        map["id"] = order.uniqueId
        return map
    }

    /*
        Get sell orders (Ask Orders) in ascending order of price and
        Get buy orders (Bid Orders) in descending order of price
        then create the final response map
        For improvements:
         - we can add limit param
     */
    fun getByPair(pair: String): MutableMap<String, Any>{
        val askOrders = repository.findByPairAndSideAndStateOrderByPriceAsc(pair, "sell")
        val bidOrders = repository.findByPairAndSideAndStateOrderByPriceDesc(pair, "buy")
        val map: MutableMap<String, Any> = mutableMapOf()
        map["Asks"] = askOrders
        map["Bids"] = bidOrders
        return map
    }

}