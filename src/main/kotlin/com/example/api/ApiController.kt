package com.example.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val repository: LimitOrderRepository, private val orderService: OrderService, private val tradeService: TradeService) {

    //  Get order for a given ID
    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String): LimitOrder? {
        return repository.findByUniqueId(id)
    }

    //  Get order book for a given currency pair
    @GetMapping("{currency}/orderbook")
    fun getOrderBookByPair(@PathVariable currency: String): MutableMap<String, Any>{
        return orderService.getByPair(currency)
    }

    //  Get trade history for a given currency pair
    @GetMapping("{currency}/tradehistory")
    fun getTradeHistoryByPair(@PathVariable currency: String): MutableList<Any>{
        return tradeService.getByPair(currency)
    }

    /*
        Create a new order, given the required params
        if any of the param is missing, the API will return 400 status
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun addOrder(@RequestBody order: LimitOrder): MutableMap<String, String?>{
        return orderService.create(order)
    }

}