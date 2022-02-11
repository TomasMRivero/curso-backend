package com.tomasmartinez.cursobackend.service.impl;

import com.tomasmartinez.cursobackend.builder.CategoryBuilder;
import com.tomasmartinez.cursobackend.model.document.Category;
import com.tomasmartinez.cursobackend.model.request.CategoryRequest;
import com.tomasmartinez.cursobackend.model.response.CategoryResponse;
import com.tomasmartinez.cursobackend.repository.CategoryRepository;
import com.tomasmartinez.cursobackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) throws Exception {
        validateCreateRequest(request);
        Category doc = repository.save(CategoryBuilder.requestToDocument(request));
        return CategoryBuilder.documentToResponse(doc);
    }

    @Override
    public CategoryResponse findCategoryByCode(String code) {
        return CategoryBuilder.documentToResponse(repository.findByCode(code));
    }

    @Override
    public CategoryResponse findCategoryById(String id) {
        return CategoryBuilder.documentToResponse(repository.findById(id).get());
    }

    @Override
    public List<CategoryResponse> findAllCategories() {
        return CategoryBuilder.listDocumentToResponse(repository.findAll());
    }

    private void validateCreateRequest(CategoryRequest req) throws Exception {
        if( !Objects.isNull(repository.findByCode(req.getCode())) ||
            !Objects.isNull(repository.findByDescription(req.getDescription())))
            throw new Exception("La categoría ya existe");
    }
}
