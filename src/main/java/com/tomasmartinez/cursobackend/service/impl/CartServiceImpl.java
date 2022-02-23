package com.tomasmartinez.cursobackend.service.impl;

import com.tomasmartinez.cursobackend.builder.CartBuilder;
import com.tomasmartinez.cursobackend.builder.CartItemBuilder;
import com.tomasmartinez.cursobackend.config.ApplicationProperties;
import com.tomasmartinez.cursobackend.handle.NotFoundException;
import com.tomasmartinez.cursobackend.handle.UpdateContentException;
import com.tomasmartinez.cursobackend.model.document.Cart;
import com.tomasmartinez.cursobackend.model.document.CartItem;
import com.tomasmartinez.cursobackend.model.document.Product;
import com.tomasmartinez.cursobackend.model.request.CartItemRequest;
import com.tomasmartinez.cursobackend.model.response.CartResponse;
import com.tomasmartinez.cursobackend.repository.CartRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import com.tomasmartinez.cursobackend.service.CartService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final ApplicationProperties properties;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public CartResponse addItemToCart(CartItemRequest request, String token) throws Exception {
        validateCartItemRequest(request);
        Cart cart;
        try{
            cart = getCart(token);
        }catch (Exception e){
            cart = buildCart(token);
        }
        try {
            CartItem item = validateUpdateRequest(request.getAmount(), request.getCode(), cart);
            item.setAmount(item.getAmount() + request.getAmount());
            item.setModifiedDate(LocalDateTime.now());
            validateAmount(productRepository.findByCode(request.getCode()), request.getAmount());
        }catch(NotFoundException e){
            cart.getItems().add(CartItemBuilder.requestToDocument(request));
        }
        cartRepository.save(cart);
        cart.setModifiedDate(LocalDateTime.now());
        return CartBuilder.documentToResponse(cart);
    }

    @Override
    public CartResponse updateItemFromCart(int amount, String code, String token) throws Exception {
        Cart cart = getCart(token);
        validateUpdateRequest(amount, code, cart).setAmount(amount);
        cart.setModifiedDate(LocalDateTime.now());
        cartRepository.save(cart);
        return CartBuilder.documentToResponse(cart);
    }

    @Override
    public CartResponse deleteItemFromCart(String code, String token) throws Exception {
        Cart cart = getCart(token);
        cart.setItems(cart.getItems().stream()
                .filter(i -> !i.getCode().equals(code))
                .collect(Collectors.toList()));
        cart.setModifiedDate(LocalDateTime.now());
        cartRepository.save(cart);
        return CartBuilder.documentToResponse(cart);
    }

    @Override
    public CartResponse showCart(String token) throws Exception {
        Cart cart = getCart(token);
        return CartBuilder.documentToResponse(cart);
    }

    @Override
    public void deleteCart(String token) throws Exception {
        Cart cart = getCart(token);
        cartRepository.delete(cart);
    }

    private void validateCartItemRequest(CartItemRequest request) throws Exception{
        Product prod = productRepository.findByCode(request.getCode());
        if(Objects.isNull(prod))
            throw new NotFoundException("El producto no existe");
        validateAmount(prod, request.getAmount());
    }

    private void validateAmount(Product prod, int amount) throws Exception{
        if(amount > prod.getStock())
            throw new UpdateContentException("Sin stock suficiente");
    }

    private CartItem validateUpdateRequest(int amount, String code, Cart cart) throws Exception{
        CartItem item = cart.getItems().stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst().orElseThrow(() -> new NotFoundException("El item no está en el carrito"));
        Product prod = productRepository.findByCode(code);
        validateAmount(prod, amount);
        return item;
    }

    private String decodeEmail(String token){
        token = token.replace("Bearer ", "");
        return Jwts.parser()
                .setSigningKey(properties.getSecret().getBytes())
                .parseClaimsJws(token)
                .getBody()
                .get("email", String.class);
    }

    private Cart getCart(String token) throws Exception {
        Cart cart = cartRepository.findByEmail(decodeEmail(token));
        if (Objects.isNull(cart)) throw new NotFoundException("No existe el carrito");
        return cart;
    }

    private Cart buildCart(String token){
        return Cart.builder()
                .email(decodeEmail(token))
                .createdDate(LocalDateTime.now())
                .items(new ArrayList<>())
                .build();
    }

}
