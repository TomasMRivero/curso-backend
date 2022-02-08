package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.database.Product;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductMongo;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductSQL;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public static <T extends Product> ProductResponse entityToResponse(T entity) {
        return ProductResponse.builder()
                .code(entity instanceof ProductSQL
                        ? ((ProductSQL) entity).getId().toString()
                        : ((ProductMongo) entity).getId())
                .name(entity.getName())
                .stock(entity.getStock())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public static List<ProductResponse> listEntityToResponse(List<Product> prods){
        List<ProductResponse> resList = new ArrayList<>();
        prods.forEach(p -> resList.add(entityToResponse(p)));
        return resList;
    }

}
