package com.tomasmartinez.cursobackend.model.document;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private Product product;
    private int amount;
}
