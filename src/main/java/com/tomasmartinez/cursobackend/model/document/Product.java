package com.tomasmartinez.cursobackend.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("product")
public class Product {
    @Id
    private String id;
    @Indexed(unique=true)
    private String code;
    private String description;
    private Category category;
    private double price;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private int stock;
}
