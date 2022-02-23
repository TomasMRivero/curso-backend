package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.config.ApplicationProperties;
import com.tomasmartinez.cursobackend.model.document.Cart;
import com.tomasmartinez.cursobackend.model.request.CartItemRequest;
import com.tomasmartinez.cursobackend.model.request.CategoryRequest;
import com.tomasmartinez.cursobackend.model.response.CartResponse;
import com.tomasmartinez.cursobackend.model.response.CategoryResponse;
import com.tomasmartinez.cursobackend.service.CartService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/carrito")
@RequiredArgsConstructor
@Log4j2
public class CartController {

    private final CartService cartService;

    @GetMapping("/")
    public CartResponse showCart(@RequestHeader("Authorization") String token) throws Exception {
        return cartService.showCart(token);
    }

    @PostMapping("/add")
    public CartResponse addItemToCart(@RequestBody @Validated CartItemRequest request,
                                      @RequestHeader("Authorization") String token) throws Exception {
        return cartService.addItemToCart(request, token);
    }

    @PutMapping("/{code}")
    public CartResponse updateItemFromCart(@PathVariable String code, @RequestParam int amount,
                                           @RequestHeader("Authorization") String token) throws Exception {
        return cartService.updateItemFromCart(amount, code, token);
    }

    @DeleteMapping("/{code}")
    public CartResponse updateItemFromCart(@PathVariable String code,
                                           @RequestHeader("Authorization") String token) throws Exception {
        return cartService.deleteItemFromCart(code, token);
    }

    @DeleteMapping("")
    public void deleteCart(@RequestHeader("Authorization") String token) throws Exception{
        cartService.deleteCart(token);
    }

}
