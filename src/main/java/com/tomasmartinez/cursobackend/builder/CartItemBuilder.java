package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.document.CartItem;
import com.tomasmartinez.cursobackend.model.request.CartItemRequest;
import com.tomasmartinez.cursobackend.model.response.CartItemResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CartItemBuilder {
    public static CartItem requestToDocument(CartItemRequest req){
        return CartItem.builder()
                .code(req.getCode())
                .amount(req.getAmount())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public static CartItemResponse documentToResponse(CartItem doc){
        return CartItemResponse.builder()
                .code(doc.getCode())
                .amount(doc.getAmount())
                .createdDate(doc.getCreatedDate())
                .build();
    }

    public static List<CartItemResponse> documentListToResponse(List<CartItem> list){
        List<CartItemResponse> responseList = new ArrayList<>();
        list.forEach(doc -> responseList.add(documentToResponse(doc)));
        return responseList;
    }
}
