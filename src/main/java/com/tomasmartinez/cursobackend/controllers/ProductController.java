package com.tomasmartinez.cursobackend.controllers;

import com.tomasmartinez.cursobackend.models.Product;
import com.tomasmartinez.cursobackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    Product createProduct(@RequestBody Product product) throws Exception{
        return productService.createProduct(product);
    }

    @GetMapping("/all")
    List<Product> getProductList() throws Exception{
        return productService.getProductList();
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Long id) throws Exception{
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    Product updateProductById(@PathVariable Long id, @RequestBody Product product) throws Exception{
        return productService.updateProductById(id, product);
    }

    @DeleteMapping("/{id}")
    void deleteProductById(@PathVariable Long id) throws Exception{
        productService.deleteProductById(id);
    }

    @GetMapping("")
    Product getProductByName(@RequestParam String name) throws Exception{
        return null;
    }

    @PutMapping("")
    Product updateProductByName(@RequestParam String name, @RequestBody Product product) throws Exception{
        return null;
    }

    @PatchMapping("")
    Product updateStockByName(@RequestParam String name, @RequestParam int stock) throws Exception{
        return null;
    }

    @DeleteMapping("")
    void deleteProductByName(@RequestParam String name) throws Exception{};


}
