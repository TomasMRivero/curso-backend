package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product) throws Exception;
    List<Product> getProductList() throws Exception;
    Product getProductById(Long id) throws Exception;
    Product updateProductById(long id, Product product) throws Exception;
    void deleteProductById(Long id) throws Exception;
    Product getProductByName(String name) throws Exception;
    Product updateProductByName(String name, Product product) throws Exception;
    Product updateStockByName(String name, int stock) throws Exception;
    void deleteProductByName(String name) throws Exception;
}
