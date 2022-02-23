package com.tomasmartinez.cursobackend.model.document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@Setter
public class Counter {
    @Id
    private String id;
    private long seq;
}
