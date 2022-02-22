package com.tomasmartinez.cursobackend.model.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponse {
    private String code;
    private int amount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
