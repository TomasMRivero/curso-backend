package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
}
