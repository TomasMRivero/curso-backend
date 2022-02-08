package com.tomasmartinez.cursobackend.model;

import com.tomasmartinez.cursobackend.builder.ProductBuilder;
import com.tomasmartinez.cursobackend.model.database.Product;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;

@Data
public class ProductFactory {
    public Product createProduct(ProductRequest req){
        switch (req.getType()){
            case "SQL":
                return ProductBuilder.requestToEntitySQL(req);
            case "MONGO":
                return ProductBuilder.requestToEntityMongo(req);
            default:
                return null;
        }
    }
}
