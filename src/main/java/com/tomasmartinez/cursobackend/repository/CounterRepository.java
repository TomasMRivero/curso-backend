package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CounterRepository extends MongoRepository<Counter, String> {
    Counter findTopByOrderByIdDesc();
}
