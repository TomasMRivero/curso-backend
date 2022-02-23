package com.tomasmartinez.cursobackend.model.response;

import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
    private int amount;
    private ProductResponse product;
}
