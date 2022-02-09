package com.tomasmartinez.cursobackend.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    @NotBlank(message = "Campo code requerido")
    private String code;
    @NotBlank(message = "Campo description requerido")
    private String description;
}
