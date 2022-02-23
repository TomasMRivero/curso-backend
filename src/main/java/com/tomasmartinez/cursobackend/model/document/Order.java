package com.tomasmartinez.cursobackend.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import utils.OrderState;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {
    @Id
    private String id;
    private String email;
    private List<OrderItem> items;
    private long orderNumber;
    @Builder.Default
    private String state = OrderState.GENERATED.getState();
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
