package com.tomasmartinez.cursobackend.model.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("cart")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cart {
    @Id
    private String id;
    private String email;
    private List<CartItem> items;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
