package com.example.api

import org.springframework.data.repository.CrudRepository

interface LimitOrderRepository : CrudRepository<LimitOrder, Long> {
    fun existsByUniqueId(unique_id: String): Boolean

    fun findByUniqueId(unique_id: String): List<LimitOrder>

    fun findByPair(pair: String): List<LimitOrder>

    fun findByPairAndSideOrderByPriceAsc(pair: String, side: String): List<LimitOrder>

    fun findByPairAndSideOrderByPriceDesc(pair: String, side: String): List<LimitOrder>
}

interface TradeRepository : CrudRepository<Trade, Long> {
    fun findByCurrencyPair(pair: String): List<Trade>
}
