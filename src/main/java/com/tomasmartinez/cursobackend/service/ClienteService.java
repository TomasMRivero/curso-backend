package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.handle.FirstApplicationException;
import com.tomasmartinez.cursobackend.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface ClienteService {
    ArrayList<Cliente> getClientList();
    Cliente getClientById(Long id) throws Exception;
    Cliente createClient(Cliente cliente);
    public Cliente updateClient(Long id, Cliente cliente) throws Exception;
    public void deleteClient(Long id) throws Exception;

}
