package com.example.api

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "market_orders")
class LimitOrder(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var uniqueId: String?,
    var userId: String,
    var pair: String,
    var price: String,
    var quantity: String,
    var side: String,
    var state: String = "new",
    var customerOrderId: String?,
    var postOnly: Boolean = false,
    var timeInForce: String = "GTC",
    var added_at: Instant = Instant.now()
)

@Entity
@Table(name = "trades")
class Trade(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
    var uniqueId: String,
    var currencyPair: String,
    var price: String,
    var quantity: String,
    var takerSide: String,
    var tradedAt: Instant = Instant.now()
)
