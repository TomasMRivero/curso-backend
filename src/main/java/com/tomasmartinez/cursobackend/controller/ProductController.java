package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;
import com.tomasmartinez.cursobackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    @PostMapping("")
    public ProductResponse createProduct(@Validated @RequestBody ProductRequest product) throws Exception {
        return service.create(product);
    }

    @GetMapping("/all")
    public List<ProductResponse> getProductList(){
        return service.searchAll();
    }

}
