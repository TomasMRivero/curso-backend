package com.tomasmartinez.cursobackend.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tomasmartinez.cursobackend.model.document.CartItem;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartResponse {
    private String id;
    private String email;
    private List<CartItemResponse> items;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
