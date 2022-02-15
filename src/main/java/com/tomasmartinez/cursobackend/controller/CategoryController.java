package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.request.CategoryRequest;
import com.tomasmartinez.cursobackend.model.response.CategoryResponse;
import com.tomasmartinez.cursobackend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("")
    @PreAuthorize("hasAuthority('category:write')")
    public CategoryResponse createCategory(@RequestBody @Validated CategoryRequest request) throws Exception {
        return service.createCategory(request);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('category:read')")
    public List<CategoryResponse> findAllCategories() { return service.findAllCategories(); }

    @GetMapping("")
    @PreAuthorize("hasAuthority('category:read')")
    public CategoryResponse findByCode(@RequestParam String code){
        return service.findCategoryByCode(code);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('category:read')")
    public CategoryResponse findById(@PathVariable String id){
        return service.findCategoryById(id);
    }
}
