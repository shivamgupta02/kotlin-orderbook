package com.example.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val repository: LimitOrderRepository, private val orderService: OrderService, private val tradeService: TradeService) {

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String): LimitOrder? {
        return repository.findByUniqueId(id)
    }

    @GetMapping("{currency}/orderbook")
    fun getOrderBookByPair(@PathVariable currency: String): MutableMap<String, Any>{
        return orderService.getByPair(currency)
    }

    @GetMapping("{currency}/tradehistory")
    fun getTradeHistoryByPair(@PathVariable currency: String): MutableList<Any>{
        return tradeService.getByPair(currency)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun addOrder(@RequestBody order: LimitOrder): MutableMap<String, String?>{
        return orderService.create(order)
    }

}