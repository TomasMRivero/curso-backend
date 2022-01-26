package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByStockGreaterThan(int stock);
    List<Product> findByStockLessThan(int stock);

    @Modifying
    @Transactional
    @Query("update Product p set p.stock = :stock where p.name = :name")
    void updateStockByName(@Param(value = "stock") int stock, @Param(value="name") String name);
}
