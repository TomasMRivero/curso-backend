package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.document.User;
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
    public ArrayList<User> getClientList(){
        return clienteService.getClientList();
    }

    @GetMapping("/cliente/{id}")
    public User getClientById(@PathVariable Long id) throws Exception {
        return clienteService.getClientById(id);
    }

    @PostMapping("/cliente")
    public User createClient(@RequestBody User user){
        return clienteService.createClient(user);
    }

    @PutMapping("/cliente/{id}")
    public User updateClient(@PathVariable Long id, @RequestBody User user) throws Exception {
        return clienteService.updateClient(id, user);
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteClient(@PathVariable Long id) throws Exception {
        clienteService.deleteClient(id);
    }


}