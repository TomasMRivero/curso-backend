package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.document.User;
import com.tomasmartinez.cursobackend.model.request.UserRequest;
import com.tomasmartinez.cursobackend.model.response.UserResponse;

import java.time.LocalDateTime;

import static com.tomasmartinez.cursobackend.security.UserRole.ADMIN;
import static com.tomasmartinez.cursobackend.security.UserRole.CLIENT;

public class UserBuilder {


    public static User requestToDocument(UserRequest req){
        return User.builder()
                .userId(req.getUserId())
                .password(req.getPassword())
                .email(req.getEmail())
                .creationDate(LocalDateTime.now())
                .grantedAuthorities(req.isAdmin()
                        ? ADMIN.getGrantedAuthorities()
                        : CLIENT.getGrantedAuthorities())
                .build();
    }

    public static UserResponse documentToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .email(user.getEmail())
                .creationDate(user.getCreationDate())
                .build();
    }
}
