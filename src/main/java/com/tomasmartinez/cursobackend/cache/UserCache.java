package com.tomasmartinez.cursobackend.cache;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasmartinez.cursobackend.config.ApplicationProperties;
import com.tomasmartinez.cursobackend.model.document.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@Log4j2
public class UserCache {

    private final HashOperations hashOperations;
    private final RedisTemplate redisTemplate;
    private final ApplicationProperties props;

    @Autowired
    UserCache(RedisTemplate redisTemplate, ObjectMapper mapper, ApplicationProperties props){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
        this.props = props;
    }

//TODO: CAPTURAR JsonProcessingException con AOP
    public void save(User user){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        hashOperations.put("USER_KEY", user.getUserId(), user.getToken());
        redisTemplate.expire("USER_KEY", (long) props.getExpirationMinutes(), TimeUnit.MINUTES);
    }

    public String getToken(String uid){
        return (String) hashOperations.get("USER_KEY", uid);
    }
}
