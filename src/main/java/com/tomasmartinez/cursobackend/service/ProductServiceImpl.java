package com.tomasmartinez.cursobackend.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasmartinez.cursobackend.cache.RedisProductRepository;
import com.tomasmartinez.cursobackend.models.Category;
import com.tomasmartinez.cursobackend.models.Product;
import com.tomasmartinez.cursobackend.repository.CategoryRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final RedisProductRepository redisProductRepository;

    @Override
    public Product createProduct(Product product) throws JsonProcessingException {
        Category category = categoryRepository.findByName(product.getCategory().getName());
        if(category == null){
            category = Category.builder().name(product.getCategory().getName()).build();
            categoryRepository.save(category);
        }
        product.setCategory(category);
        product.setCreatedDate(new Date());

        productRepository.save(product);
        redisProductRepository.save(product);

        return product;
    }

    @Override
    public List<Product> getProductList() throws Exception {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws Exception {
        Product res;
        if(redisProductRepository.findById(id) != null) res = redisProductRepository.findById(id);
        else if(productRepository.findById(id).isPresent()){
            res = productRepository.findById(id).get();
            redisProductRepository.save(res);
        }
        else throw new Exception("No encontrado");
        return res;
    }

    @Override
    public Product updateProductById(Long id, Product product) throws Exception {
        if(!productRepository.findById(id).isPresent()) throw new Exception("No encontrado");
        Category category = categoryRepository.findByName(product.getCategory().getName());
        if(category == null){
            category = Category.builder().name(product.getCategory().getName()).build();
            categoryRepository.save(category);
        }
        product.setCategory(category);
        product.setId(id);
        product.setCreatedDate(new Date());
        productRepository.save(product);
        redisProductRepository.update(product);
        return product;
    }

    @Override
    public void deleteProductById(Long id) throws Exception {
        productRepository.delete(productRepository.findById(id).orElseThrow(() -> new Exception("no encontrado")));
        redisProductRepository.delete(id);
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
}
