package com.tomasmartinez.cursobackend.service;


import com.tomasmartinez.cursobackend.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{
    private static ArrayList<User> repository = new ArrayList<User>();

    public ArrayList<User> getUserList(){
        return repository;
    }

    public User getUserById(Long id) throws Exception {
        User found = repository.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
        if(found == null) throw new Exception("No encontrado");
        return found;
    }

    public User createUser(User user){
        repository.add(user);
        return user;
    }
}
