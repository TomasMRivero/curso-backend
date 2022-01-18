package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.Product;
import com.tomasmartinez.cursobackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    ArrayList<Product> getProductList(){
        return productService.getProductList();
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Long id) throws Exception {
        return productService.getProductById(id);
    }

    @PostMapping("/")
    Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
