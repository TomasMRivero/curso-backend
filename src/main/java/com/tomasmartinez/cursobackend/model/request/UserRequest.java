package com.tomasmartinez.cursobackend.model.request;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotNull(message = "Campo userId requerido")
    @NotBlank(message = "Campo userId requerido")
    private String userId;
    @NotNull(message = "Campo email requerido")
    @NotBlank(message = "Campo email requerido")
    @Email(message = "Debe ser un email valido")
    private String email;
    @NotNull(message = "Campo password requerido")
    @Size(min = 8, max = 32, message = "Debe tener entre 8 y 32 caracteres")
    private String password;
    @Builder.Default
    private boolean isAdmin = false;
}
