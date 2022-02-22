package com.tomasmartinez.cursobackend.model.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User{
    @Id
    private String id;
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private String password;
    private String userId;
    private String email;
    private String token;
    private LocalDateTime creationDate;
}
