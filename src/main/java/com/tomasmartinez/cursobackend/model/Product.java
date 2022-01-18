package com.tomasmartinez.cursobackend.model;

public class Product {
    private static Long index = 0L;
    private Long id;
    private String title;
    private Float price;

    public Product() {
        this.id = index++;
    }

    public Product(String title, Float price) {
        this.id = index++;
        this.title = title;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
