package com.tomasmartinez.cursobackend.service.impl;

import com.tomasmartinez.cursobackend.builder.UserBuilder;
import com.tomasmartinez.cursobackend.model.document.User;
import com.tomasmartinez.cursobackend.model.request.LoginRequest;
import com.tomasmartinez.cursobackend.model.request.UserRequest;
import com.tomasmartinez.cursobackend.model.response.LoginResponse;
import com.tomasmartinez.cursobackend.model.response.UserResponse;
import com.tomasmartinez.cursobackend.repository.UserRepository;
import com.tomasmartinez.cursobackend.security.JwtProvider;
import com.tomasmartinez.cursobackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Override
    public UserResponse createUser(UserRequest request) {
        User doc = UserBuilder.requestToDocument(request);
        userRepository.save(doc);
        return UserBuilder.documentToResponse(doc);
    }

    @Override
    public LoginResponse getUser(LoginRequest request) throws Exception {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new Exception("Usuario o contraseña incorrectos"));
        if(!(   user.getUserId().equals(request.getUserId()) &&
                user.getPassword().equals(request.getPassword() )))
            throw new Exception("Usuario o contraseña incorrectos");

        String token = jwtProvider.getJwtToken(user);
        return LoginResponse.builder().userId(request.getUserId()).token(token).build();

    }
}
