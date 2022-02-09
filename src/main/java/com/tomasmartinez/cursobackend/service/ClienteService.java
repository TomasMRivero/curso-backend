package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.document.User;

import java.util.ArrayList;

public interface ClienteService {
    ArrayList<User> getClientList();
    User getClientById(Long id) throws Exception;
    User createClient(User user);
    public User updateClient(Long id, User user) throws Exception;
    public void deleteClient(Long id) throws Exception;

}
