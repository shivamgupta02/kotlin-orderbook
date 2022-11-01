package com.example.api

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "market_orders")
class LimitOrder(
    var uniqueId: String?,
    var userId: String,
    var pair: String,
    var price: String,
    var quantity: String,
    var side: String,
    var customerOrderId: String?,
    var state: String = "new",
    var postOnly: Boolean = false,
    var timeInForce: String = "GTC",
    var added_at: Instant = Instant.now(),
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
)

@Entity
@Table(name = "trades")
class Trade(
    var uniqueId: String,
    var currencyPair: String,
    var price: String,
    var quantity: String,
    var takerSide: String,
    var tradedAt: Instant = Instant.now(),
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
)
