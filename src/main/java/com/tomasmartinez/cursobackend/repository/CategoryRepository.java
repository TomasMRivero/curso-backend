package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findByCode(String code);
    Category findByName(String name);
}
