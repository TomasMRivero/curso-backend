package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product getProductById(Long id);
    Product updateProductById(Product product, Long id);
    void delete(Product product, Long id);
    Product findByNombre(String nombre);
    List<Product> findByCategoria(String categoria);
    List<Product> findAll();
}
