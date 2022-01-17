package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.handle.FirstApplicationException;
import com.tomasmartinez.cursobackend.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/coder")
public class UserController {

    @GetMapping("/user")
    public ArrayList<User> getUserList(){
        return userService.getUserList();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user/cust-ex")
    public void throwException() throws FirstApplicationException {
        throw new FirstApplicationException("Error: todo malió sal");
    }
}