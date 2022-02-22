package com.tomasmartinez.cursobackend.model.document;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String code;
    private int amount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
