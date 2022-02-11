package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.document.Category;
import com.tomasmartinez.cursobackend.model.document.Product;
import com.tomasmartinez.cursobackend.model.request.CategoryRequest;
import com.tomasmartinez.cursobackend.model.response.CategoryResponse;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public static <T extends Category> List<CategoryResponse> listDocumentToResponse(List<T> documents){
        List<CategoryResponse> resList = new ArrayList<>();
        documents.forEach(doc -> resList.add(documentToResponse(doc)));
        return resList;
    }
}
