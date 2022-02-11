package com.tomasmartinez.cursobackend.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("category")
public class Category {
    @Id
    private String id;
    @Indexed(unique=true)
    private String code;
    @Indexed(unique=true)
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}
