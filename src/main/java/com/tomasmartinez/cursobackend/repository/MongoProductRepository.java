package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoProductRepository extends MongoRepository<Product, String> {
    Product findByNombre(String nombre);
    List<Product> findByCategoria(String categoria);
}
