package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.Product;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Product updateProductById(Product product, Long id) {
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(Product product, Long id) {
        product.setId(id);
        repository.delete(product);
    }

    @Override
    public Product findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Product> findByCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        repository.findAll().forEach(productList::add);
        return productList;
    }
}
