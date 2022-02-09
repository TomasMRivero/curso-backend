package com.tomasmartinez.cursobackend.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponse {
    private String id;
    private String code;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}
