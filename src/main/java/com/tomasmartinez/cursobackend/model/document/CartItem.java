package com.tomasmartinez.cursobackend.model.document;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String id;
    private int ammount;
}
