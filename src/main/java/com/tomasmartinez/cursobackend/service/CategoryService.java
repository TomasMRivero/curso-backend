package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.request.CategoryRequest;
import com.tomasmartinez.cursobackend.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request) throws Exception;
    CategoryResponse findCategoryByCode(String code);
    CategoryResponse findCategoryById(String id);
    List<CategoryResponse> findAllCategories();
}
