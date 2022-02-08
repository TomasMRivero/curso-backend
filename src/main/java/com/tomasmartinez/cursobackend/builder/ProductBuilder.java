package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.database.concrete.ProductMongo;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductSQL;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;

import java.util.Date;

public class ProductBuilder {

    public static ProductSQL requestToEntitySQL(ProductRequest req) {
        return ProductSQL.builder()
                .name(req.getName())
                .stock(req.getStock())
                .createdDate(new Date())
                .build();
    }

    public static ProductMongo requestToEntityMongo(ProductRequest req){
        return ProductMongo.builder()
                .name(req.getName())
                .stock(req.getStock())
                .createdDate(new Date())
                .build();
    }

}
