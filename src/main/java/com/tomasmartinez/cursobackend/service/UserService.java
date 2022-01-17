package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.handle.FirstApplicationException;
import com.tomasmartinez.cursobackend.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    ArrayList<User> getUserList();
    User getUserById(Long id) throws Exception;
    User createUser(User user);

}
