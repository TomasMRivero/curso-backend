package com.tomasmartinez.cursobackend.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private String id;
    private String code;
    private String description;
    private CategoryResponse category;
    private double price;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private int stock;
}
