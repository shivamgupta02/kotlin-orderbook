package com.example.api

import org.springframework.stereotype.Service

@Service
class TradeService(private val repository: TradeRepository) {

    /*
        Create a trade, called after an order is received and created
        we can add extra validations to confirm orders belong to same pair
        we can add quantity checks to execute an order partially or completely
    */
    fun createTrade(makerOrder: LimitOrder, takerOrder: LimitOrder){
        val trade = Trade(
            price = makerOrder.price,
            currencyPair = makerOrder.pair,
            takerSide = takerOrder.side,
            quantity = takerOrder.quantity,
            uniqueId = java.util.UUID.randomUUID().toString()
        )
        repository.save(trade)
    }

    /*
        Get all the trades for a given pair and create a response array
        For improvements:
         - we can add limit param
         - we can add filters for takerSide or time period
     */
    fun getByPair(pair: String): MutableList<Any>{
        val list: MutableList<Any> = mutableListOf()
        val trades = repository.findByCurrencyPair(pair)
        for(trade in trades) {
            val map: MutableMap<String, Any> = mutableMapOf()
            map["id"] = trade.uniqueId
            map["price"] = trade.price
            map["quantity"] = trade.quantity
            map["currencyPair"] = trade.currencyPair
            map["takerSide"] = trade.takerSide
            map["tradedAt"] = trade.tradedAt
            list += map
        }
        return list

    }


}