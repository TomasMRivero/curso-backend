package com.tomasmartinez.cursobackend.repository;

import com.tomasmartinez.cursobackend.model.database.concrete.ProductMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepository extends MongoRepository<ProductMongo, String> {
}
