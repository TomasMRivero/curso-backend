package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getProductList();
    Product getProductById(Long id) throws Exception;
    Product createProduct(Product product);
}
