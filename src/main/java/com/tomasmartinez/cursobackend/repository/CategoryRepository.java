package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findByCode(String code);
    Category findByDescription(String description);
}
