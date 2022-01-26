package com.tomasmartinez.cursobackend.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasmartinez.cursobackend.models.Category;
import com.tomasmartinez.cursobackend.models.Product;
import com.tomasmartinez.cursobackend.repository.CategoryRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ObjectMapper mapper;

    @PostConstruct
    private void PostConstruct() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }

    @Override
    public Product createProduct(Product product) throws JsonProcessingException {
        try{
            Category category = categoryRepository.findByName(product.getCategory().getName());
            if(category == null){
                category = Category.builder().name(product.getCategory().getName()).build();
                categoryRepository.save(category);
            }
            product.setCategory(category);
            product.setCreatedDate(new Date());

            mapperToString(product);
            mapperToMap(product);
            mapperToClass(product);

            return productRepository.save(product);
        } catch (JsonProcessingException e) {
            log.error("Error al convertir a string", e);
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }
        return product;
    }

    @Override
    public List<Product> getProductList() throws Exception {
        return null;
    }

    @Override
    public Product getProductById(Long id) throws Exception {
        return null;
    }

    @Override
    public Product updateProductById(long id, Product product) throws Exception {
        return null;
    }

    @Override
    public void deleteProductById(Long id) throws Exception {

    }

    @Override
    public Product getProductByName(String name) throws Exception {
        return null;
    }

    @Override
    public Product updateProductByName(String name, Product product) throws Exception {
        return null;
    }

    @Override
    public Product updateStockByName(String name, int stock) throws Exception {
        return null;
    }

    @Override
    public void deleteProductByName(String name) throws Exception {

    }

    void mapperToString(Product product) throws JsonProcessingException {
        String prodString = mapper.writeValueAsString(product);
        log.info("Producto en formato String : {}", prodString);
    }

    void mapperToMap(Product product) throws JsonProcessingException {
        String prodString = mapper.writeValueAsString(product);
        var prodMap = mapper.readValue(prodString, Map.class);
        log.info("Producto en formato map: {}", prodMap);
    }

    void mapperToClass(Product product) throws JsonProcessingException {
        String prodString = mapper.writeValueAsString(product);
        Product prodClass = mapper.readValue(prodString, Product.class);
        log.info("Producto en formato clase: {}", prodClass);
    }
}
