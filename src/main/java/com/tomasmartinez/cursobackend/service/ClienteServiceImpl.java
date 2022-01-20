package com.tomasmartinez.cursobackend.service;


import com.tomasmartinez.cursobackend.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteServiceImpl implements ClienteService {
    private static ArrayList<Cliente> repository = new ArrayList<Cliente>();

    public ArrayList<Cliente> getUserList(){
        return repository;
    }

    public Cliente getUserById(Long id) throws Exception {
        Cliente found = repository.stream()
                .filter(cliente -> cliente.getId() == id)
                .findAny()
                .orElse(null);
        if(found == null) throw new Exception("No encontrado");
        return found;
    }

    public Cliente createUser(Cliente cliente){
        repository.add(cliente);
        return cliente;
    }
}
