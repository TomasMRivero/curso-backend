package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.Product;
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
    Product getProductById(@PathVariable Long id){
        return productService.getProductByid(id);
    }

    @PostMapping("/")
    Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
