package com.tomasmartinez.cursobackend.service.impl;

import com.tomasmartinez.cursobackend.builder.ProductBuilder;
import com.tomasmartinez.cursobackend.model.ProductFactory;
import com.tomasmartinez.cursobackend.model.database.Product;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductMongo;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductSQL;
import com.tomasmartinez.cursobackend.model.request.ProductRequest;
import com.tomasmartinez.cursobackend.model.response.ProductResponse;
import com.tomasmartinez.cursobackend.repository.ProductMongoRepository;
import com.tomasmartinez.cursobackend.repository.ProductSQLRepository;
import com.tomasmartinez.cursobackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductSQLRepository sqlRepository;
    private final ProductMongoRepository mongoRepository;

    private final ProductFactory factory = new ProductFactory();

    @Override
    public ProductResponse create(ProductRequest product) throws Exception {
        var entity = factory.createProduct(product);
        if (entity == null) throw new Exception("error");
        if (entity instanceof ProductSQL)
            sqlRepository.save((ProductSQL) entity);
        else
            mongoRepository.save((ProductMongo) entity);
        return ProductBuilder.entityToResponse(entity);
    }

    @Override
    public List<ProductResponse> searchAll() {
        List<ProductResponse> list = new ArrayList<>();
        list.addAll(ProductBuilder.listEntityToResponse(sqlRepository.findAll()));
        list.addAll(ProductBuilder.listEntityToResponse(mongoRepository.findAll()));
        return list;
    }
}
