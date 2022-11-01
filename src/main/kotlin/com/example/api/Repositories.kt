package com.example.api

import org.springframework.data.repository.CrudRepository

interface LimitOrderRepository : CrudRepository<LimitOrder, Long> {

    fun findByUniqueId(unique_id: String): LimitOrder?

    fun findByPairAndSideAndStateOrderByPriceAsc(pair: String, side: String, state: String = "new"): List<LimitOrder>

    fun findByPairAndSideAndStateOrderByPriceDesc(pair: String, side: String, state: String = "new"): List<LimitOrder>
}

interface TradeRepository : CrudRepository<Trade, Long> {
    fun findByCurrencyPair(pair: String): List<Trade>
}
