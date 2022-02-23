package com.tomasmartinez.cursobackend.controller;

import com.tomasmartinez.cursobackend.model.response.OrderResponse;
import com.tomasmartinez.cursobackend.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orden")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/generate")
    public OrderResponse generateOrder(@RequestHeader("Authorization") String token) throws Exception {
        return orderService.generateOrder(token);
    }

    @GetMapping("")
    public List<OrderResponse> showUserOrders(@RequestHeader("Authorization") String token) throws Exception {
        return orderService.showOrders(orderService.decodeEmail(token));
    }

    @GetMapping("/{email}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<OrderResponse> showOrdersByEmail(@PathVariable String email){
        return orderService.showOrders(email);
    }
}
