package com.tomasmartinez.cursobackend.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "Campo code requerido")
    private String code;
    @NotBlank(message = "Campo description requerido")
    private String description;
    @NotNull(message = "Campo price requerido")
    private double price;
    private int stock;
    @NotNull(message = "Campo category requerido")
    private CategoryRequest category;
}
