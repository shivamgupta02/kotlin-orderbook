package com.example.api;

import org.springframework.stereotype.Service;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/api/TradeService;", "", "repository", "Lcom/example/api/TradeRepository;", "(Lcom/example/api/TradeRepository;)V", "createTrade", "", "makerOrder", "Lcom/example/api/LimitOrder;", "takerOrder", "getByPair", "", "pair", "", "api"})
@org.springframework.stereotype.Service
public class TradeService {
    private final com.example.api.TradeRepository repository = null;
    
    public TradeService(@org.jetbrains.annotations.NotNull
    com.example.api.TradeRepository repository) {
        super();
    }
    
    public void createTrade(@org.jetbrains.annotations.NotNull
    com.example.api.LimitOrder makerOrder, @org.jetbrains.annotations.NotNull
    com.example.api.LimitOrder takerOrder) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.util.List<java.lang.Object> getByPair(@org.jetbrains.annotations.NotNull
    java.lang.String pair) {
        return null;
    }
}