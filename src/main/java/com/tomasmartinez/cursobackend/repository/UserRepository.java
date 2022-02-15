package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String userId);
}
