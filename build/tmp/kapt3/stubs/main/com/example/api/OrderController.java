package com.example.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ \u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\b\u0001\u0010\f\u001a\u00020\rH\u0017J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0017J\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0001\u0010\u0011\u001a\u00020\u000bH\u0017J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u000bH\u0017J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0001\u0010\u0011\u001a\u00020\u000bH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/api/OrderController;", "", "repository", "Lcom/example/api/LimitOrderRepository;", "orderService", "Lcom/example/api/OrderService;", "tradeService", "Lcom/example/api/TradeService;", "(Lcom/example/api/LimitOrderRepository;Lcom/example/api/OrderService;Lcom/example/api/TradeService;)V", "addOrder", "", "", "order", "Lcom/example/api/LimitOrder;", "findAll", "", "findByCurrency", "currency", "findOne", "", "id", "getTradeHistory", "", "api"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/orders"})
@org.springframework.web.bind.annotation.RestController
public class OrderController {
    private final com.example.api.LimitOrderRepository repository = null;
    private final com.example.api.OrderService orderService = null;
    private final com.example.api.TradeService tradeService = null;
    
    public OrderController(@org.jetbrains.annotations.NotNull
    com.example.api.LimitOrderRepository repository, @org.jetbrains.annotations.NotNull
    com.example.api.OrderService orderService, @org.jetbrains.annotations.NotNull
    com.example.api.TradeService tradeService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.GetMapping(value = {"/"})
    public java.lang.Iterable<com.example.api.LimitOrder> findAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{id}"})
    public java.util.List<com.example.api.LimitOrder> findOne(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PathVariable
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.GetMapping(value = {"{currency}/orderbook"})
    public java.util.Map<java.lang.String, java.lang.Object> findByCurrency(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PathVariable
    java.lang.String currency) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.GetMapping(value = {"{currency}/tradehistory"})
    public java.util.List<java.lang.Object> getTradeHistory(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PathVariable
    java.lang.String currency) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PostMapping
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
    public java.util.Map<java.lang.String, java.lang.String> addOrder(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestBody
    com.example.api.LimitOrder order) {
        return null;
    }
}