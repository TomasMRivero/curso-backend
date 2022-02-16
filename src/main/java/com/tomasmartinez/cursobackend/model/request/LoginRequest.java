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
public class LoginRequest {
    @NotNull(message = "campo userId requerido")
    @NotBlank(message = "campo userId requerido")
    private String userId;

    @NotNull(message = "campo password requerido")
    @NotBlank(message = "campo password requerido")
    private String password;
}
