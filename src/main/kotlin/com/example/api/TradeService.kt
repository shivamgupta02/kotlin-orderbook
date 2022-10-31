package com.example.api

import org.springframework.stereotype.Service

@Service
class TradeService(private val repository: TradeRepository) {

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