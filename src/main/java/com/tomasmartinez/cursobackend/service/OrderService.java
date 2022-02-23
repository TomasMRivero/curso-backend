package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.document.Cart;
import com.tomasmartinez.cursobackend.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse generateOrder(String token) throws Exception;
    List<OrderResponse> showOrders(String email);
    public String decodeEmail(String token) throws Exception;
}
