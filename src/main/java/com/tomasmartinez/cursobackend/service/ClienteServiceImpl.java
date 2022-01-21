package com.tomasmartinez.cursobackend.service;


import com.tomasmartinez.cursobackend.handle.NotFoundException;
import com.tomasmartinez.cursobackend.handle.NullUpdateContentException;
import com.tomasmartinez.cursobackend.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteServiceImpl implements ClienteService {
    private static ArrayList<Cliente> repository = new ArrayList<Cliente>();

    @Override
    public ArrayList<Cliente> getClientList(){
        return repository;
    }

    @Override
    public Cliente getClientById(Long id) throws Exception {
        Cliente found = repository.stream()
                .filter(cliente -> cliente.getId() == id)
                .findAny()
                .orElse(null);
        if(found == null) throw new NotFoundException("No encontrado");
        return found;
    }

    @Override
    public Cliente createClient(Cliente cliente){
        repository.add(cliente);
        return cliente;
    }

    @Override
    public Cliente updateClient(Long id, Cliente cliente) throws Exception {
        Cliente found = repository.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        if (found == null) throw new NotFoundException("No encontrado");
        if (cliente.getNombre()==null && cliente.getApellido()==null) throw new NullUpdateContentException();
        if (cliente.getNombre() != null) found.setNombre(cliente.getNombre());
        if (cliente.getApellido() != null) found.setApellido(cliente.getApellido());
        return found;
    }

    @Override
    public void deleteClient(Long id) throws Exception{
        if(!repository.removeIf(c-> id == c.getId())) throw new NotFoundException("No encontrado");
    }
}
