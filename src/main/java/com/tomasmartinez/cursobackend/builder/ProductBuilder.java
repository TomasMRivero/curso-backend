package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.document.Product;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;

import java.time.LocalDateTime;

public class ProductBuilder {
    public static Product requestToDocumentCreate(ProductRequest req){
        return Product.builder()
                .code(req.getCode())
                .description(req.getDescription())
                .category(CategoryBuilder.requestToDocument(req.getCategory()))
                .price(req.getPrice())
                .stock(req.getStock())
                .creationDate(LocalDateTime.now())
                .build();
    }
    public static Product requestToDocumentUpdate(ProductRequest req){
        return Product.builder()
                .code(req.getCode())
                .description(req.getDescription())
                .price(req.getPrice())
                .category(CategoryBuilder.requestToDocument(req.getCategory()))
                .price(req.getPrice())
                .stock(req.getStock())
                .modificationDate(LocalDateTime.now())
                .build();
    }

    public static ProductResponse documentToResponseCreate(Product doc){
        return ProductResponse.builder()
                .id(doc.getId())
                .code(doc.getCode())
                .creationDate(doc.getCreationDate())
                .modificationDate(doc.getModificationDate())
                .build();
    }

    public static ProductResponse documentToResponseSearch(Product doc){
        return ProductResponse.builder()
                .id(doc.getId())
                .code(doc.getCode())
                .description(doc.getDescription())
                .category(CategoryBuilder.documentToResponse(doc.getCategory()))
                .price(doc.getPrice())
                .stock(doc.getStock())
                .creationDate(doc.getCreationDate())
                .modificationDate(doc.getModificationDate())
                .build();
    }
}
