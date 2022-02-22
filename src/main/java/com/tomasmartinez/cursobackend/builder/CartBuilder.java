package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.document.Cart;
import com.tomasmartinez.cursobackend.model.response.CartResponse;

public class CartBuilder {
    public static CartResponse documentToResponse(Cart doc){
        return CartResponse.builder()
                .id(doc.getId())
                .email(doc.getEmail())
                .items(CartItemBuilder.documentListToResponse(doc.getItems()))
                .createdDate(doc.getCreatedDate())
                .modifiedDate(doc.getModifiedDate())
                .build();
    }
}
