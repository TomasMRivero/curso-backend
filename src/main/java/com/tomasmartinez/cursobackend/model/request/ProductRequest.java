package com.tomasmartinez.cursobackend.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "El campo type no puede ser vacío")
    @Pattern(regexp = "^(SQL|MONGO)$", message = "Solo acepta: SQL, MONGO")
    private String type;

    @NotBlank(message = "El campo name es obligatorio")
    private String name;
    private int stock;
}
