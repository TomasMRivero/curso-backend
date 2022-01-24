package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByNombre(String nombre);
    List<Product> findByCategoria(String categoria);

    @Modifying
    @Query("update Product p set p.stock = :stock where p.id = :id")
    void updateStock(@Param(value="stock") Integer stock, @Param(value="id") Long id);

    @Modifying
    @Query("update Product  p set p.stock = :stock where p.nombre = :nombre")
    void updateStock(@Param(value="stock") Integer stock, @Param(value="name") String name);
}
