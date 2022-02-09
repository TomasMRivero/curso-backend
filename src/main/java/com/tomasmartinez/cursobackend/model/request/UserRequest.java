package com.tomasmartinez.cursobackend.model.request;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Campo userId requerido")
    private String userId;
    @NotBlank(message = "Campo email requerido")
    @Email(message = "Debe ser un email valido")
    private String email;
    @Size(min = 8, max = 32, message = "Debe tener entre 8 y 32 caracteres")
    private String password;
}
