package com.tomasmartinez.cursobackend.service;

import com.tomasmartinez.cursobackend.model.request.CartItemRequest;
import com.tomasmartinez.cursobackend.model.response.CartResponse;

public interface CartService {
    CartResponse addItemToCart(CartItemRequest request, String token) throws Exception;
    CartResponse updateItemFromCart(int amount, String code, String token) throws Exception;
    CartResponse deleteItemFromCart(String code, String token) throws Exception;
    CartResponse showCart(String token) throws Exception;
    void deleteCart(String token) throws Exception;
}
