package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.database.concrete.ProductSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSQLRepository extends CrudRepository<ProductSQL, Long> {
    List<ProductSQL> findAll();
}
