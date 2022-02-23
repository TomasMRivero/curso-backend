package com.tomasmartinez.cursobackend.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private String id;
    private String email;
    private List<OrderItemResponse> items;
    private long orderNumber;
    private String state;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
