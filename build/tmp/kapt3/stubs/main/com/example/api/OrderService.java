package com.example.api;

import org.springframework.stereotype.Service;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\r\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/api/OrderService;", "", "repository", "Lcom/example/api/LimitOrderRepository;", "tradeService", "Lcom/example/api/TradeService;", "(Lcom/example/api/LimitOrderRepository;Lcom/example/api/TradeService;)V", "create", "", "", "order", "Lcom/example/api/LimitOrder;", "getByPair", "pair", "api"})
@org.springframework.stereotype.Service
public class OrderService {
    private final com.example.api.LimitOrderRepository repository = null;
    private final com.example.api.TradeService tradeService = null;
    
    public OrderService(@org.jetbrains.annotations.NotNull
    com.example.api.LimitOrderRepository repository, @org.jetbrains.annotations.NotNull
    com.example.api.TradeService tradeService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public java.util.Map<java.lang.String, java.lang.String> create(@org.jetbrains.annotations.NotNull
    com.example.api.LimitOrder order) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public java.util.Map<java.lang.String, java.lang.Object> getByPair(@org.jetbrains.annotations.NotNull
    java.lang.String pair) {
        return null;
    }
}