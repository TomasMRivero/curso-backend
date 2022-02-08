package com.tomasmartinez.cursobackend.model.database;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductMongo;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductSQL;
import lombok.*;
import lombok.experimental.SuperBuilder;



@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProductSQL.class, name = "ProductSQL"),
        @JsonSubTypes.Type(value = ProductMongo.class, name = "ProductMongo")
})
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class Product {
    private String name;
    private int stock;
}
