package com.tomasmartinez.cursobackend;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasmartinez.cursobackend.models.Category;
import com.tomasmartinez.cursobackend.models.Product;
import com.tomasmartinez.cursobackend.repository.CategoryRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerMockMvcTest {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setup(){
        System.out.println("inicializando testeos en Product Controller");
	}

    @BeforeEach
    public void init() {
        System.out.println("---Product Controller Request---");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("finalizando testeos en Product Controller");
    }

    @Test
    public void getProductList() throws Exception {
        MvcResult result = mockMvc.perform(get("http://localhost:8080/api/product/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        List<Product> productResult = mapper.readValue(content, List.class);
        Assert.notNull(productResult, "Lista de Product no nula");
        Assert.notEmpty(productResult, "Lista de Product no vacia");
        Assert.isTrue(productResult.size() >= 3, "Size is ok >= 3");
    }

    @Test
    public void getProductById() throws Exception {
        Long testId = 3L;
        MvcResult result = mockMvc.perform(get("http://localhost:8080/api/product/{id}", testId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Product productResult = mapper.readValue(content, Product.class);
        Assert.notNull(productResult, "Product no nulo");
        Assert.isTrue(productResult.getId().equals(testId), "Product id ok");
        Assert.isTrue(productResult.getName().equals("fideos"), "Product name ok");
    }

    @Test
    public void getProductByName() throws Exception{
        String testName = "fideos";
        MvcResult result = mockMvc.perform(get("http://localhost:8080/api/product")
                .param("name", testName))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Product productResult = mapper.readValue(content, Product.class);
        Assert.notNull(productResult, "Product no nulo");
        Assert.isTrue(productResult.getName().equals(testName), "Product name ok");
    }
}
