package com.tomasmartinez.cursobackend.cache;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasmartinez.cursobackend.model.document.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@Log4j2
public class UserCache {
    private final HashOperations hashOperations;
    private final RedisTemplate redisTemplate;

    UserCache(RedisTemplate redisTemplate, ObjectMapper mapper){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

//TODO: CAPTURAR JsonProcessingException con AOP
    public void save(User user){
        hashOperations.put(user.getUserId(), user.getUserId(), user.getToken());
        redisTemplate.expire(user.getUserId(), 30, TimeUnit.SECONDS);
    }

    public void update(User user){
        hashOperations.put(user.getUserId(), user.getUserId(), user.getToken());
        redisTemplate.expire(user.getUserId(), 30, TimeUnit.SECONDS);
    }

    public void delete(User user){
        hashOperations.delete(user.getUserId(), user.getUserId());
    }
}
