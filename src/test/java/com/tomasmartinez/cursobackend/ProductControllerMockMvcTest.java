package com.tomasmartinez.cursobackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasmartinez.cursobackend.models.Category;
import com.tomasmartinez.cursobackend.models.Product;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.Commit;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerMockMvcTest {

    private String url;
    private final ObjectMapper mapper = new ObjectMapper();

    @LocalServerPort
    private int port;
    private static Long itemId;

    @BeforeEach
    public void setUp(){
        url = String.format("http://localhost:%d/api/", port);
    }

    @Test
    public void createProduct() throws IOException{
        String route = url + "product";

        Category testCategory = Category.builder().name("testCategory").build();
        Product testProduct = Product.builder().id(itemId).name("test").category(testCategory).stock(10).createdDate(new Date()).build();
        StringEntity entity = new StringEntity(mapper.writeValueAsString(testProduct));

        HttpPost req = new HttpPost(route);
        req.setEntity(entity);
        req.setHeader("Accept", "application/json");
        req.setHeader("Content-type", "application/json");
        HttpResponse res = HttpClientBuilder.create().build().execute(req);

        String content = EntityUtils.toString(res.getEntity());
        Product result = mapper.readValue(content, Product.class);

        itemId = result.getId();

        Assert.isTrue(
                res.getStatusLine().getStatusCode() == 200,
                "Status 200 OK");
        Assert.notNull(result, "Producto no nulo");
        Assert.isTrue(
                result.getId().equals(itemId),
                "Id OK: " + result.getId() + " == " + itemId );
        Assert.isTrue(
                result.getName().equals("test"),
                "Name OK: " + result.getName() +" == 'test'" );
        Assert.isTrue(
                result.getCategory().getName().equals("testCategory"),
                "Category OK: " + result.getCategory().getName() + " == 'testCategory'" );
        Assert.isTrue(
                result.getStock() == 10,
                "Stock OK: " + result.getStock() + " == 10"
        );

    }

    @Test
    public void getAllProducts() throws IOException{
        String route = url + "product/all";

        HttpUriRequest req = new HttpGet(route);
        HttpResponse res = HttpClientBuilder.create().build().execute(req);

        String content = EntityUtils.toString(res.getEntity());

        List<Product> result = mapper.readValue(content, List.class);

        Assert.isTrue(
                res.getStatusLine().getStatusCode() == 200,
                "Status 200 OK");
        Assert.notNull(result, "Lista no nula");
        Assert.notEmpty(result, "lista no vacia");
    }

    @Test
    public void getProductById() throws IOException{
        String route = url + "product/" + itemId;

        HttpUriRequest req = new HttpGet(route);
        HttpResponse res = HttpClientBuilder.create().build().execute(req);

        String content = EntityUtils.toString(res.getEntity());

        Product result = mapper.readValue(content, Product.class);

        Assert.isTrue(
                res.getStatusLine().getStatusCode() >= 200,
                "Status 200 OK");
        Assert.notNull(result, "Producto no nulo");
        Assert.isTrue(
                result.getId() == itemId,
                "Id OK: " + result.getId() + " == " + itemId );
        Assert.isTrue(
                result.getName().equals("test"),
                "Name OK: " + result.getName() +" == 'test'" );
        Assert.isTrue(
                result.getCategory().getName().equals("testCategory"),
                "Category OK: " + result.getCategory().getName() + " == 'testCategory'" );
        Assert.isTrue(
                result.getStock() == 10,
                "Stock OK: " + result.getStock() + " == 10"
        );
    }

    @Test
    public void updateProductById() throws IOException{

        String route = url + "product/" + itemId;

        Category testCategory = Category.builder().name("testCategory").build();
        Product testProduct = Product.builder().name("updateTest").category(testCategory).stock(10).createdDate(new Date()).build();
        StringEntity entity = new StringEntity(mapper.writeValueAsString(testProduct));

        HttpPut req = new HttpPut(route);
        req.setEntity(entity);
        req.setHeader("Accept", "application/json");
        req.setHeader("Content-type", "application/json");
        HttpResponse res = HttpClientBuilder.create().build().execute(req);

        String content = EntityUtils.toString(res.getEntity());
        Product result = mapper.readValue(content, Product.class);

        Assert.notNull(result, "Producto no nulo");
        Assert.isTrue(
                result.getId().equals(itemId),
                "Id OK: " + result.getId() + " == " + itemId );
        Assert.isTrue(
                result.getName().equals("updateTest"),
                "Name OK: " + result.getName() +" == 'updateTest'" );
        Assert.isTrue(
                result.getCategory().getName().equals("testCategory"),
                "Category OK: " + result.getCategory().getName() + " == 'testCategory'" );
        Assert.isTrue(
                result.getStock() == 10,
                "Stock OK: " + result.getStock() + " == 10"
        );
    }

    @Test
    public void deleteProductById() throws IOException{

        String route = url + "product/" + itemId;

        HttpUriRequest req = new HttpDelete(route);
        HttpResponse res = HttpClientBuilder.create().build().execute(req);

        Assert.isTrue(
                res.getStatusLine().getStatusCode() == 200,
                "Status 200 OK");
    }
}
