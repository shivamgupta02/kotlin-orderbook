package com.example.api;

import java.time.Instant;
import javax.persistence.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\b\u0017\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012R\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001a\u0010\r\u001a\u00020\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\b\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b\'\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001a\u00a8\u00064"}, d2 = {"Lcom/example/api/LimitOrder;", "", "id", "", "uniqueId", "", "userId", "pair", "price", "quantity", "side", "state", "customerOrderId", "postOnly", "", "timeInForce", "added_at", "Ljava/time/Instant;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/time/Instant;)V", "getAdded_at", "()Ljava/time/Instant;", "setAdded_at", "(Ljava/time/Instant;)V", "getCustomerOrderId", "()Ljava/lang/String;", "setCustomerOrderId", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPair", "setPair", "getPostOnly", "()Z", "setPostOnly", "(Z)V", "getPrice", "setPrice", "getQuantity", "setQuantity", "getSide", "setSide", "getState", "setState", "getTimeInForce", "setTimeInForce", "getUniqueId", "setUniqueId", "getUserId", "setUserId", "api"})
@javax.persistence.Table(name = "market_orders")
@javax.persistence.Entity
public class LimitOrder {
    @org.jetbrains.annotations.Nullable
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Id
    private java.lang.Long id;
    @org.jetbrains.annotations.Nullable
    private java.lang.String uniqueId;
    @org.jetbrains.annotations.NotNull
    private java.lang.String userId;
    @org.jetbrains.annotations.NotNull
    private java.lang.String pair;
    @org.jetbrains.annotations.NotNull
    private java.lang.String price;
    @org.jetbrains.annotations.NotNull
    private java.lang.String quantity;
    @org.jetbrains.annotations.NotNull
    private java.lang.String side;
    @org.jetbrains.annotations.NotNull
    private java.lang.String state;
    @org.jetbrains.annotations.Nullable
    private java.lang.String customerOrderId;
    private boolean postOnly;
    @org.jetbrains.annotations.NotNull
    private java.lang.String timeInForce;
    @org.jetbrains.annotations.NotNull
    private java.time.Instant added_at;
    
    public LimitOrder(@org.jetbrains.annotations.Nullable
    java.lang.Long id, @org.jetbrains.annotations.Nullable
    java.lang.String uniqueId, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String pair, @org.jetbrains.annotations.NotNull
    java.lang.String price, @org.jetbrains.annotations.NotNull
    java.lang.String quantity, @org.jetbrains.annotations.NotNull
    java.lang.String side, @org.jetbrains.annotations.NotNull
    java.lang.String state, @org.jetbrains.annotations.Nullable
    java.lang.String customerOrderId, boolean postOnly, @org.jetbrains.annotations.NotNull
    java.lang.String timeInForce, @org.jetbrains.annotations.NotNull
    java.time.Instant added_at) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.Long getId() {
        return null;
    }
    
    public void setId(@org.jetbrains.annotations.Nullable
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.String getUniqueId() {
        return null;
    }
    
    public void setUniqueId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getUserId() {
        return null;
    }
    
    public void setUserId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getPair() {
        return null;
    }
    
    public void setPair(@org.jetbrains.annotations.NotNull
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
    public java.lang.String getSide() {
        return null;
    }
    
    public void setSide(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getState() {
        return null;
    }
    
    public void setState(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public java.lang.String getCustomerOrderId() {
        return null;
    }
    
    public void setCustomerOrderId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public boolean getPostOnly() {
        return false;
    }
    
    public void setPostOnly(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTimeInForce() {
        return null;
    }
    
    public void setTimeInForce(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public java.time.Instant getAdded_at() {
        return null;
    }
    
    public void setAdded_at(@org.jetbrains.annotations.NotNull
    java.time.Instant p0) {
    }
}