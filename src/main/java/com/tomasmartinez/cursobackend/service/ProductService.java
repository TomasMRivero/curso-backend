package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest product);
    List<ProductResponse> searchAll();
}
