package com.tomasmartinez.cursobackend.model;

import com.tomasmartinez.cursobackend.builder.ProductBuilder;
import com.tomasmartinez.cursobackend.model.database.Product;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import lombok.Data;

@Data
public class ProductFactory {
    public Product createproduct(ProductRequest req){
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
