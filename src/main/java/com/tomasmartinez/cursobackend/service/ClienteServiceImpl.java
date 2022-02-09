package com.tomasmartinez.cursobackend.service;


import com.tomasmartinez.cursobackend.annotation.UpdateOrDelete;
import com.tomasmartinez.cursobackend.handle.NotFoundException;
import com.tomasmartinez.cursobackend.handle.NullUpdateContentException;
import com.tomasmartinez.cursobackend.model.document.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteServiceImpl implements ClienteService {
    private static ArrayList<User> repository = new ArrayList<User>();

    @Override
    public ArrayList<User> getClientList(){
        return repository;
    }

    @Override
    public User getClientById(Long id) throws Exception {
        User found = repository.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
        if(found == null) throw new NotFoundException("No encontrado");
        return found;
    }

    @Override
    public User createClient(User user){
        repository.add(user);
        return user;
    }

    @Override
    @UpdateOrDelete
    public User updateClient(Long id, User user) throws Exception {
        User found = repository.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null);
        if (found == null) throw new NotFoundException("No encontrado");
        if (user.getNombre()==null && user.getApellido()==null) throw new NullUpdateContentException();
        if (user.getNombre() != null) found.setNombre(user.getNombre());
        if (user.getApellido() != null) found.setApellido(user.getApellido());
        return found;
    }

    @Override
    @UpdateOrDelete
    public void deleteClient(Long id) throws Exception{
        if(!repository.removeIf(c-> id == c.getId())) throw new NotFoundException("No encontrado");
    }
}
