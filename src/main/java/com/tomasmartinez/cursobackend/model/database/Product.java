package com.tomasmartinez.cursobackend.model.database;

import com.fasterxml.jackson.annotation.*;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductMongo;
import com.tomasmartinez.cursobackend.model.database.concrete.ProductSQL;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProductSQL.class, name = "ProductSQL"),
        @JsonSubTypes.Type(value = ProductMongo.class, name = "ProductMongo")
})
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class Product {
    private String name;
    private int stock;
    @JsonProperty("created_date")
    private Date createdDate;
}
