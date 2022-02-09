package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.document.Product;
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

    @GetMapping("/producto/{categoria}")
    public List<Product> findAllAllByStockSortedLimit(@PathVariable String categoria,
                                                      @RequestParam String orderBy,
                                                      @RequestParam int limit){
        return service.findAllAllByStockSortedLimit(categoria, orderBy, limit);
    }

    @GetMapping("/producto")
    public Product findByName(@RequestParam String nombre){
        return service.findByNombre(nombre);
    }

    @PutMapping("/producto")
    public void updateProductByName(@RequestParam String nombre, @RequestBody Product product){
        service.updateProductByName(product, nombre);
    }

    @PutMapping("/producto/stock")
    public void updateStockByName(@RequestParam String nombre, @RequestParam Integer stock){
        service.updateStockByName(nombre, stock);
    }

    @GetMapping("/producto/categorias")
    public List<Product> findByCategoria(@RequestParam String categoria){
        return service.findByCategoria(categoria);
    }

    @DeleteMapping("/producto")
    public void deleteProduct(@RequestParam String nombre){
        service.delete(nombre);
    }
}
