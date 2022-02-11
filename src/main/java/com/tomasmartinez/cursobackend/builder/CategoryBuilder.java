package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.document.Category;
import com.tomasmartinez.cursobackend.model.request.CategoryRequest;
import com.tomasmartinez.cursobackend.model.response.CategoryResponse;

import java.time.LocalDateTime;

public class CategoryBuilder {
    public static Category requestToDocument(CategoryRequest req){
        return Category.builder()
                .code(req.getCode())
                .description(req.getDescription())
                .creationDate(LocalDateTime.now())
                .build();
    }

    public static CategoryResponse documentToResponse(Category doc){
        return CategoryResponse.builder()
                .id(doc.getId())
                .code(doc.getCode())
                .description(doc.getDescription())
                .creationDate(doc.getCreationDate())
                .modificationDate(doc.getModificationDate())
                .build();
    }
}
