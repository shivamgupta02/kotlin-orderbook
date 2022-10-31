package com.example.api;

import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0017\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\t\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/example/api/Trade;", "", "id", "", "uniqueId", "", "currencyPair", "price", "quantity", "takerSide", "tradedAt", "Ljava/time/Instant;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/time/Instant;)V", "getCurrencyPair", "()Ljava/lang/String;", "setCurrencyPair", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPrice", "setPrice", "getQuantity", "setQuantity", "getTakerSide", "setTakerSide", "getTradedAt", "()Ljava/time/Instant;", "setTradedAt", "(Ljava/time/Instant;)V", "getUniqueId", "setUniqueId", "api"})
@javax.persistence.Table(name = "trades")
@javax.persistence.Entity
public class Trade {
    @org.jetbrains.annotations.Nullable
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Id
    private java.lang.Long id;
    @org.jetbrains.annotations.NotNull
    private java.lang.String uniqueId;
    @org.jetbrains.annotations.NotNull
    private java.lang.String currencyPair;
    @org.jetbrains.annotations.NotNull
    private java.lang.String price;
    @org.jetbrains.annotations.NotNull
    private java.lang.String quantity;
    @org.jetbrains.annotations.NotNull
    private java.lang.String takerSide;
    @org.jetbrains.annotations.NotNull
    private java.time.Instant tradedAt;
    
    public Trade(@org.jetbrains.annotations.Nullable
    java.lang.Long id, @org.jetbrains.annotations.NotNull
    java.lang.String uniqueId, @org.jetbrains.annotations.NotNull
    java.lang.String currencyPair, @org.jetbrains.annotations.NotNull
    java.lang.String price, @org.jetbrains.annotations.NotNull
    java.lang.String quantity, @org.jetbrains.annotations.NotNull
    java.lang.String takerSide, @org.jetbrains.annotations.NotNull
    java.time.Instant tradedAt) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Long getId() {
        return null;
    }
    
    public void setId(@org.jetbrains.annotations.Nullable
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getUniqueId() {
        return null;
    }
    
    public void setUniqueId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getCurrencyPair() {
        return null;
    }
    
    public void setCurrencyPair(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getPrice() {
        return null;
    }
    
    public void setPrice(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getQuantity() {
        return null;
    }
    
    public void setQuantity(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTakerSide() {
        return null;
    }
    
    public void setTakerSide(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.time.Instant getTradedAt() {
        return null;
    }
    
    public void setTradedAt(@org.jetbrains.annotations.NotNull
    java.time.Instant p0) {
    }
}