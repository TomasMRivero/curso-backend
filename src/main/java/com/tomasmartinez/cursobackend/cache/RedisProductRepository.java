package com.tomasmartinez.cursobackend.cache;


import com.tomasmartinez.cursobackend.models.Product;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisProductRepository {
    public static final String PRODUCT_KEY = "PRODUCT";

    private final HashOperations hashOperations;

    private final RedisTemplate redisTemplate;

    public RedisProductRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Product product){
        hashOperations.put(PRODUCT_KEY, product.getId(), product);
    }

    public List<Product> findAll(){
        return hashOperations.values(PRODUCT_KEY);
    }

    public Product findById(Long id) {
        return (Product) hashOperations.get(PRODUCT_KEY, id);
    }

}
