package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByUserId(String userId);
}
