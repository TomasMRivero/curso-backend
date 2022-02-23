package com.tomasmartinez.cursobackend.builder;

import com.tomasmartinez.cursobackend.model.document.Order;
import com.tomasmartinez.cursobackend.model.document.OrderItem;
import com.tomasmartinez.cursobackend.model.response.OrderItemResponse;
import com.tomasmartinez.cursobackend.model.response.OrderResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private static OrderItemResponse itemToResponse(OrderItem item){
        return OrderItemResponse.builder()
                .product(ProductBuilder.documentToResponseSearch(item.getProduct()))
                .amount(item.getAmount())
                .build();
    }

    private static List<OrderItemResponse> listItemToResponse(List<OrderItem> list){
        List<OrderItemResponse> responseList = new ArrayList<>();
        list.forEach(item -> responseList.add(itemToResponse(item)));
        return responseList;
    }

    public static OrderResponse documentToResponse(Order doc){
        return OrderResponse.builder()
                .id(doc.getId())
                .email(doc.getEmail())
                .items(listItemToResponse(doc.getItems()))
                .orderNumber(doc.getOrderNumber())
                .state(doc.getState())
                .createdDate(doc.getCreatedDate())
                .modifiedDate(doc.getModifiedDate())
                .build();
    }
}
