package com.example.ecommerce.proyecto.controller;

import com.example.ecommerce.proyecto.dto.OrderDto;
import com.example.ecommerce.proyecto.service.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Juan Carlos Peralta Olivera
 */
@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderDto order) {
        String message = orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable UUID id) {
        OrderDto orderDto = orderService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

}
