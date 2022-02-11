package com.tomasmartinez.cursobackend.service.impl;

import com.tomasmartinez.cursobackend.builder.ProductBuilder;
import com.tomasmartinez.cursobackend.model.document.Category;
import com.tomasmartinez.cursobackend.model.document.Product;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;
import com.tomasmartinez.cursobackend.repository.CategoryRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import com.tomasmartinez.cursobackend.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ProductResponse createProduct(ProductRequest req) throws Exception{
        Category categoryToSet = validateCreateRequest(req);
        Product doc = ProductBuilder.requestToDocumentCreate(req);
        doc.setCategory(categoryToSet);
        productRepository.save(doc);
        return ProductBuilder.documentToResponseCreate(doc);
    }

    @Override
    public ProductResponse findByCode(String code) {
        return ProductBuilder.documentToResponseSearch(productRepository.findByCode(code));
    }

    @Override
    public List<ProductResponse> findByDescription(String description) {
        return ProductBuilder.listDocumentToResponse(productRepository.findByDescription(description));
    }

    @Override
    public List<ProductResponse> findAll() {
        return ProductBuilder.listDocumentToResponse(productRepository.findAll());
    }

    @Override
    public List<ProductResponse> findByCategoryCode(String code) throws Exception {
        Category category = validateCategory(code);
        return ProductBuilder.listDocumentToResponse(productRepository.findByCategory(category));
    }

    @Override
    public ProductResponse updateProductByCode(ProductRequest req, String code) throws Exception {
        Category categoryToSet = validateUpdateRequest(req);
        Product doc = ProductBuilder.requestToDocumentUpdate(req);
        doc.setId(productRepository.findByCode(code).getId());
        doc.setCreationDate((productRepository.findByCode(code).getCreationDate()));
        doc.setCategory(categoryToSet);
        productRepository.save(doc);
        return ProductBuilder.documentToResponseCreate(doc);
    }

    @Override
    public void deleteByCode(String code) throws Exception {
        productRepository.delete(validateProductByCode(code));
    }

    private Category validateCreateRequest(ProductRequest request) throws Exception{
        if(!Objects.isNull(productRepository.findByCode(request.getCode())))
            throw new Exception("El producto ya existe");
        return validateCategory(request.getCategoryCode());
    }

    private Category validateUpdateRequest(ProductRequest request) throws Exception {
        validateProductByCode(request.getCode());
        return validateCategory(request.getCategoryCode());
    }

    private Product validateProductByCode(String code) throws Exception {
        Product prod = productRepository.findByCode(code);
        if(Objects.isNull(prod))
            throw new Exception("El producto no existe");
        return prod;
    }

    private Category validateCategory(String code) throws Exception{
        Category cat = categoryRepository.findByCode(code);
        if(Objects.isNull(cat)) throw new Exception("La categoria no existe");
        return cat;
    }
}
