package com.example.api;

import org.springframework.data.repository.CrudRepository;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2 = {"Lcom/example/api/LimitOrderRepository;", "Lorg/springframework/data/repository/CrudRepository;", "Lcom/example/api/LimitOrder;", "", "existsByUniqueId", "", "unique_id", "", "findByPair", "", "pair", "findByPairAndSideOrderByPriceAsc", "side", "findByPairAndSideOrderByPriceDesc", "findByUniqueId", "api"})
public abstract interface LimitOrderRepository extends org.springframework.data.repository.CrudRepository<com.example.api.LimitOrder, java.lang.Long> {
    
    public abstract boolean existsByUniqueId(@org.jetbrains.annotations.NotNull
    java.lang.String unique_id);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.api.LimitOrder> findByUniqueId(@org.jetbrains.annotations.NotNull
    java.lang.String unique_id);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.api.LimitOrder> findByPair(@org.jetbrains.annotations.NotNull
    java.lang.String pair);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.api.LimitOrder> findByPairAndSideOrderByPriceAsc(@org.jetbrains.annotations.NotNull
    java.lang.String pair, @org.jetbrains.annotations.NotNull
    java.lang.String side);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.api.LimitOrder> findByPairAndSideOrderByPriceDesc(@org.jetbrains.annotations.NotNull
    java.lang.String pair, @org.jetbrains.annotations.NotNull
    java.lang.String side);
}