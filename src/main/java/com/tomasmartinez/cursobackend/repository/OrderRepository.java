package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByOrderNumber(long orderNumber);
    List<Order> findByEmail(String email);
}
