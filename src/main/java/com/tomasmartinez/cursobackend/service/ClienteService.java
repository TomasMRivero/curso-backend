package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.handle.FirstApplicationException;
import com.tomasmartinez.cursobackend.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ClienteService {
    ArrayList<Cliente> getUserList();
    Cliente getUserById(Long id) throws Exception;
    Cliente createUser(Cliente user);

}
