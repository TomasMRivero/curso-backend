package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class MongoProductTemplateRepositoryImpl implements MongoProductTemplateRepository{

    @Autowired
    MongoTemplate template;

    @Override
    public List<Product> findAllAllByStockSortedLimit(String categoria, String orderBy, int limit) {
        var query = new Query();
        query.with(Sort.by(
                orderBy.equalsIgnoreCase("DESC")
                    ? Sort.Order.desc("stock")
                    : Sort.Order.asc("stock")
        ));
        query.limit(limit);
        query.addCriteria(Criteria.where("categoria").is(categoria));

        return template.find(query, Product.class);
    }
}
