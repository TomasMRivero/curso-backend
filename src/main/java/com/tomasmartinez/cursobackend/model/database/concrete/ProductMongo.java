package com.tomasmartinez.cursobackend.model.database.concrete;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.tomasmartinez.cursobackend.model.database.Product;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("product_mongo")
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Document("product")
public class ProductMongo extends Product {
    @Id
    private String id;
}
