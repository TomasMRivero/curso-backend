package com.tomasmartinez.cursobackend.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequest {
    private String code;
    private int amount;
}
