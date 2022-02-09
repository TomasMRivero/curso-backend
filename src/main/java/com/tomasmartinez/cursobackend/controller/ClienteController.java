package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.document.Cliente;
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
    public ArrayList<Cliente> getClientList(){
        return clienteService.getClientList();
    }

    @GetMapping("/cliente/{id}")
    public Cliente getClientById(@PathVariable Long id) throws Exception {
        return clienteService.getClientById(id);
    }

    @PostMapping("/cliente")
    public Cliente createClient(@RequestBody Cliente cliente){
        return clienteService.createClient(cliente);
    }

    @PutMapping("/cliente/{id}")
    public Cliente updateClient(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception {
        return clienteService.updateClient(id, cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteClient(@PathVariable Long id) throws Exception {
        clienteService.deleteClient(id);
    }


}