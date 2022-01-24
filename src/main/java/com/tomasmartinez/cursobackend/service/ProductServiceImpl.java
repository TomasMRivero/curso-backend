package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.Product;
import com.tomasmartinez.cursobackend.repository.MongoProductRepository;
import com.tomasmartinez.cursobackend.repository.MongoProductTemplateRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        repository.findByNombre(nombre);
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
    public List<Product> findByStockGreaterThan(int stock) {
        return repository.findStockGreaterThan(stock);
    }

    @Override
    public List<Product> findByStockOrderByNombreDesc(int stock) {
        return repository.findStockOrderByNombreDesc(stock);
    }

    @Override
    public List<Product> findByStockOrderByNombreAsc(int stock) {
        return repository.findStockOrderByNombreAsc(stock);
    }

    @Override
    public List<Product> findAllAllByStockSortedLimit(String categoria, String orderBy, int limit) {
        return template.findAllAllByStockSortedLimit(categoria, orderBy, limit);
    }


    @Override
    public void updateProductByName(Product product, String name) {
        var query = new Query();
        query.addCriteria(Criteria.where("nombre").is(name));
        var update = new Update();
        update.set("nombre", product.getNombre());
        template.updateMulti(query, update, Product.class);

    }

    @Override
    public void updateStockByName(String nombre, Integer stock) {
        var update = repository.findByNombre(nombre);
        update.setStock(stock);
    }

    @Override
    public void delete(String nombre) {
        repository.delete(repository.findByNombre(nombre));
    }
}
