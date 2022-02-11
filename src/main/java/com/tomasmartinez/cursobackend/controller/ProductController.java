package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;
import com.tomasmartinez.cursobackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private ProductService service;

    @PostMapping("/productos")
    public ProductResponse createProduct(@RequestBody @Validated ProductRequest request) throws Exception {
        return service.createProduct(request);
    }

    @GetMapping("/productos/all")
    public List<ProductResponse> findAllProducts(){
        return service.findAll();
    }

    @GetMapping("/productos/desc")
    public List<ProductResponse> findByDescription(@RequestParam String description){
        return service.findByDescription(description);
    }

    @GetMapping("/productos")
    public ProductResponse findByCode(@RequestParam String code){
        return service.findByCode(code);
    }

    @PutMapping("/productos")
    public ProductResponse updateProductByCode(@RequestBody @Validated ProductRequest request,
                                               @RequestParam String code) throws Exception {
        return service.updateProductByCode(request, code);
    }

    @GetMapping("/productos/{categoryCode}")
    public List<ProductResponse> findAllProductsByCategoryCode(@PathVariable String categoryCode) throws Exception {
        return service.findByCategoryCode(categoryCode);
    }

    @DeleteMapping("/productos")
    public void deleteProductByCode(@RequestParam String code) throws Exception {
        service.deleteByCode(code);
    }
}
