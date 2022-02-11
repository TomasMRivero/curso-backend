package com.tomasmartinez.cursobackend.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class User {
    @Id
    private String id;
    @Indexed(unique=true)
    private String userId;
    @Indexed(unique=true)
    private String email;
    private String password;
    private String token;
}
