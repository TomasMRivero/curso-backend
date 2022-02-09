package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.document.Product;
import com.tomasmartinez.cursobackend.repository.MongoProductRepository;
import com.tomasmartinez.cursobackend.repository.MongoProductTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private MongoProductRepository repository;
    @Autowired
    private MongoProductTemplateRepository template;

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    @Override
    public List<Product> findAllAllByStockSortedLimit(String categoria, String orderBy, int limit) {
        return template.findAllAllByStockSortedLimit(categoria, orderBy, limit);
    }


    @Override
    public void updateProductByName(Product product, String name) {
        var update = repository.findByNombre(name);
        update.setNombre(product.getNombre());
        update.setCategoria(product.getCategoria());
        update.setStock(product.getStock());
        repository.save(update);
    }

    @Override
    public void updateStockByName(String nombre, Integer stock) {
        var update = repository.findByNombre(nombre);
        update.setStock(stock);
        repository.save(update);
    }

    @Override
    public void delete(String nombre) {
        repository.delete(repository.findByNombre(nombre));
    }
}
