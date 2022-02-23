package com.tomasmartinez.cursobackend.service.impl;

import com.tomasmartinez.cursobackend.builder.OrderBuilder;
import com.tomasmartinez.cursobackend.config.ApplicationProperties;
import com.tomasmartinez.cursobackend.model.document.*;
import com.tomasmartinez.cursobackend.model.response.OrderResponse;
import com.tomasmartinez.cursobackend.repository.CartRepository;
import com.tomasmartinez.cursobackend.repository.CounterRepository;
import com.tomasmartinez.cursobackend.repository.OrderRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import com.tomasmartinez.cursobackend.service.OrderService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CounterRepository counterRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final ApplicationProperties properties;

    @Override
    public OrderResponse generateOrder(String token) throws Exception {
        Cart cart = cartRepository.findByEmail(decodeEmail(token));
        List<OrderItem> productList = new ArrayList<>();
        cart.getItems().forEach(item -> productList.add(
                        OrderItem.builder()
                            .product(productRepository.findByCode(item.getCode()))
                            .amount(item.getAmount())
                            .build()));

        Order doc = orderRepository.save(Order.builder()
                .email(cart.getEmail())
                .items(productList)
                .orderNumber(getNext())
                .createdDate(LocalDateTime.now())
                .build());
        return OrderBuilder.documentToResponse(doc);
    }

    @Override
    public List<OrderResponse> showOrders(String email) {
        return OrderBuilder.listDocumentToResponse(orderRepository.findByEmail(email));
    }

    private long getNext(){
        Counter last = counterRepository.findTopByOrderByIdDesc();
        if (Objects.isNull(last)) counterRepository.save(new Counter(0));
        long lastNum = last.getSeq();
        Counter next = new Counter(lastNum + 1);
        counterRepository.save(next);
        return next.getSeq();
    }

    public String decodeEmail(String token) throws Exception{
        token = token.replace("Bearer ", "");
        return Jwts.parser()
                .setSigningKey(properties.getSecret().getBytes())
                .parseClaimsJws(token)
                .getBody()
                .get("email", String.class);
    }

}
