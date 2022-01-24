package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    Product findByNombre(String nombre);
    List<Product> findAll();
    List<Product> findByStockGreaterThan(int stock);
    List<Product> findByStockOrderByNombreDesc(int stock);
    List<Product> findByStockOrderByNombreAsc(int stock);
    List<Product> findAllAllByStockSortedLimit(String categoria, String orderBy, int limit);
    List<Product> findByCategoria(String categoria);

    void updateProductByName(Product product, String name);
    void updateStockByName(String nombre, Integer stock);
    void delete(String nombre);
}
