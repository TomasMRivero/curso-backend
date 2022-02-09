package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Product;

import java.util.List;

public interface MongoProductTemplateRepository {
    List<Product> findAllAllByStockSortedLimit(String categoria, String orderBy, int limit);

}
