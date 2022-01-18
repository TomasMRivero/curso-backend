package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.handle.FirstApplicationException;
import com.tomasmartinez.cursobackend.model.User;
import com.tomasmartinez.cursobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ArrayList<User> getUserList(){
        return userService.getUserList();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user/cust-ex")
    public void throwException() throws FirstApplicationException {
        throw new FirstApplicationException("Error: todo malio sal");
    }
}