package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.request.LoginRequest;
import com.tomasmartinez.cursobackend.model.request.UserRequest;
import com.tomasmartinez.cursobackend.model.response.LoginResponse;
import com.tomasmartinez.cursobackend.model.response.UserResponse;
import com.tomasmartinez.cursobackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public UserResponse createUser(@RequestBody UserRequest request, @RequestParam @Validated Optional<Boolean> isAdmin){
        if(isAdmin.isPresent() && isAdmin.get()) request.setAdmin(true);
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request)
            throws Exception {
        return userService.getUser(request);
    }

}