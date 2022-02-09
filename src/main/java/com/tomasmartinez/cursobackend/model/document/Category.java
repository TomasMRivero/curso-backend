package com.tomasmartinez.cursobackend.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("category")
public class Category {
    @Id
    private String id;
    private String code;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}
