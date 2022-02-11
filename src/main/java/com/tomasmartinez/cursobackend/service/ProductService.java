package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.document.Category;
import com.tomasmartinez.cursobackend.model.document.Product;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest req) throws Exception;
    ProductResponse findByCode(String code);
    List<ProductResponse> findByDescription(String description);
    List<ProductResponse> findAll();
    List<ProductResponse> findByCategoryCode(String code) throws Exception;
    ProductResponse updateProductByCode(ProductRequest req, String code) throws Exception;
    void deleteByCode(String code) throws Exception;
}
