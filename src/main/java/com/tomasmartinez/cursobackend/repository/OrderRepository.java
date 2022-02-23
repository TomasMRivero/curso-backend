package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByOrderNumber(long orderNumber);
    Order findByEmail(String email);
}
