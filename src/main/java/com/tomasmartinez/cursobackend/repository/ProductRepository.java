package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Category;
import com.tomasmartinez.cursobackend.model.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByDescription(String description);
    Product findByCode(String code);
    List<Product> findByCategory(Category category);
}
