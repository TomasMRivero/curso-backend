package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.handle.FirstApplicationException;
import com.tomasmartinez.cursobackend.model.Cliente;
import com.tomasmartinez.cursobackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/coder")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente")
    public ArrayList<Cliente> getUserList(){
        return clienteService.getUserList();
    }

    @GetMapping("/user/{id}")
    public Cliente getUserById(@PathVariable Long id) throws Exception {
        return clienteService.getUserById(id);
    }

    @PostMapping("/user")
    public Cliente createUser(@RequestBody Cliente cliente){
        return clienteService.createUser(cliente);
    }

    @GetMapping("/user/cust-ex")
    public void throwException() throws FirstApplicationException {
        throw new FirstApplicationException("Error: todo malio sal");
    }
}