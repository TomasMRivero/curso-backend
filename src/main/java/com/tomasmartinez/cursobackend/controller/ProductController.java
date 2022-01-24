package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.Product;
import com.tomasmartinez.cursobackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coder")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/producto")
    public Product createProduct(@RequestBody Product product){
        return service.createProduct(product);
    }

    @GetMapping("/producto/all")
    public List<Product> findProducts(){
        return service.findAll();
    }

    @GetMapping("/producto")
    public Product findByName(@RequestParam String nombre){
        return service.findByNombre(nombre);
    }

    @PutMapping("/producto")
    public void updateStockByName(@RequestParam String nombre, @RequestParam Integer stock){
        service.updateStockByName(nombre, stock);
    }

    @GetMapping("/producto/{id}")
    public Product getProductByid(@PathVariable Long id){
        return service.getProductById(id);
    }

    @PutMapping("/producto/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product product){
        return service.updateProductById(product, id);
    }

    @PutMapping("/producto/{id}/updateStock")
    public void updateStockById(@PathVariable Long id, @RequestParam Integer stock){
        service.updateStock(id, stock);
    }

    @GetMapping("/producto/categorias")
    public List<Product> findByCategoria(@RequestParam String categoria){
        return service.findByCategoria(categoria);
    }

    @DeleteMapping("/producto/{id}")
    public void deleteProduct(@PathVariable Long id){
        Product prod = service.getProductById(id);
        service.delete(prod, id);
    }
}
