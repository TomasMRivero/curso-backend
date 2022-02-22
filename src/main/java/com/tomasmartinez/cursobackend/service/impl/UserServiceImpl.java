package com.tomasmartinez.cursobackend.service.impl;

import com.tomasmartinez.cursobackend.builder.UserBuilder;
import com.tomasmartinez.cursobackend.cache.UserCache;
import com.tomasmartinez.cursobackend.model.document.User;
import com.tomasmartinez.cursobackend.model.request.LoginRequest;
import com.tomasmartinez.cursobackend.model.request.UserRequest;
import com.tomasmartinez.cursobackend.model.response.LoginResponse;
import com.tomasmartinez.cursobackend.model.response.UserResponse;
import com.tomasmartinez.cursobackend.repository.UserRepository;
import com.tomasmartinez.cursobackend.security.JwtProvider;
import com.tomasmartinez.cursobackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCache cache;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder encoder;


    @Override
    public UserResponse createUser(UserRequest request) {
        request.setPassword(encoder.encode(request.getPassword()));
        User doc = UserBuilder.requestToDocument(request);
        userRepository.save(doc);
        return UserBuilder.documentToResponse(doc);
    }

    @Override
    public LoginResponse getUser(LoginRequest request) throws Exception {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new Exception("Usuario o contraseña incorrectos"));
        if(!(   user.getUserId().equals(request.getUserId()) &&
                encoder.matches(request.getPassword(), user.getPassword()) ))
            throw new Exception("Usuario o contraseña incorrectos");

        if(Objects.isNull(cache.getToken(user.getUserId()))){
            user.setToken(jwtProvider.getJwtToken(user));
            cache.save(user);
        } else {
            user.setToken(cache.getToken(user.getUserId()));
        }

        return LoginResponse.builder().userId(request.getUserId()).token(user.getToken()).build();
    }
}
