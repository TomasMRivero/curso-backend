package com.tomasmartinez.cursobackend.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ApplicationProperties {
    @Value("${jwt.expiration-minutes}")
    private int expirationMinutes;
    @Value("${jwt.secret}")
    private String secret;

    public int expMillis(){
        return this.expirationMinutes * 60 * 1000;
    }

}
