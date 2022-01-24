package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.Product;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface MongoProductTemplateRepository {
    List<Product> findAllAllByStockSortedLimit(String categoria, String orderBy, int limit);

    void updateMulti(Query query, Update update, Class<Product> productClass);
}
