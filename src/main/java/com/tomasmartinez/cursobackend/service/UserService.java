package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.request.LoginRequest;
import com.tomasmartinez.cursobackend.model.request.UserRequest;
import com.tomasmartinez.cursobackend.model.response.LoginResponse;
import com.tomasmartinez.cursobackend.model.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    LoginResponse getUser(LoginRequest request) throws Exception;
}
