package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService{
    private static ArrayList<Product> repository = new ArrayList<Product>();

    @Override
    public ArrayList<Product> getProductList() { return repository; }

    @Override
    public Product getProductById(Long id) throws Exception {
        Product found = repository.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElse(null);
        if(found == null) throw new Exception("producto no encontrado");
        return found;
    }

    @Override
    public Product createProduct(Product product) {
        repository.add(product);
        return product;
    }
}
