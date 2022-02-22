package com.tomasmartinez.cursobackend.security;

import com.tomasmartinez.cursobackend.config.ApplicationProperties;
import com.tomasmartinez.cursobackend.model.document.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtProvider implements Serializable {

    private final ApplicationProperties props;

    public String getJwtToken(User user){
        return Jwts.builder()
                .setSubject(user.getUserId())
                .claim("authorities", user.getGrantedAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + props.expMillis()))
                .signWith(SignatureAlgorithm.HS512, props.getSecret().getBytes())
                .compact();
    }
}
