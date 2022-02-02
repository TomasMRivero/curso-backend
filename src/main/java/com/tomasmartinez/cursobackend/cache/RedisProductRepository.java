package com.tomasmartinez.cursobackend.cache;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasmartinez.cursobackend.models.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Repository
@Log4j2
public class RedisProductRepository {
    public static final String PRODUCT_KEY = "PRODUCT";

    private final HashOperations hashOperations;

    private final RedisTemplate redisTemplate;

    private final ObjectMapper mapper;

    @PostConstruct
    private void PostConstruct() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }


    public RedisProductRepository(RedisTemplate redisTemplate, ObjectMapper mapper){
        this.redisTemplate = redisTemplate;
        this.mapper = mapper;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Product product){
        try{
            hashOperations.put(PRODUCT_KEY, product.getId(), product);
            log.info("REDIS - Producto creado: {}", mapper.writeValueAsString(product));
        } catch (JsonProcessingException e) {
            log.error("Error al convertir a string", e);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
    }

    public void update(Product product){
        try{
            hashOperations.put(PRODUCT_KEY, product.getId(), product);;
            log.info("REDIS - Producto actualizado: {}", mapper.writeValueAsString(product));
        } catch (JsonProcessingException e) {
            log.error("Error al convertir a string", e);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
    }

    public void delete(Long id){
        hashOperations.delete(PRODUCT_KEY, id);
        log.info("REDIS - Producto borrado: {}", id);
    }

    public List<Product> findAll(){
        return hashOperations.values(PRODUCT_KEY);
    }

    public Product findById(Long id) {
        return (Product) hashOperations.get(PRODUCT_KEY, id);
    }
}