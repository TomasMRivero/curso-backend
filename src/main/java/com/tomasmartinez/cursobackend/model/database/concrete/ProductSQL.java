package com.tomasmartinez.cursobackend.model.database.concrete;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.tomasmartinez.cursobackend.model.database.Product;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeName("product_sq")
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "product")
public class ProductSQL extends Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String name;
    Date createdDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductSQL that = (ProductSQL) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
