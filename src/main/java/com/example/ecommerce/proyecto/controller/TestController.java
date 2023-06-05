package com.example.ecommerce.proyecto.controller;

import com.example.ecommerce.proyecto.dto.EmailNotification;
import com.example.ecommerce.proyecto.dto.OrderItemDto;
import com.example.ecommerce.proyecto.repository.OrderRepository;
import com.example.ecommerce.proyecto.service.interfaces.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Juan Carlos Peralta Olivera
 */
@AllArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private OrderRepository orderRepository;

    private EmailService emailService;

    @GetMapping("/{orderId}")
    public String getTotalPrice(@PathVariable UUID orderId) {
        double totalPriceSQL = orderRepository.getTotalPriceByOrderId(orderId.toString());
        double totalPriceJPQL = orderRepository.getTotalPrice(orderId);
        return "Total price SQL: " + totalPriceSQL + " Total price JPQL: " + totalPriceJPQL;
    }

    @GetMapping("/items/{orderId}")
    public List<OrderItemDto> getListItems(@PathVariable UUID orderId) {
        List<OrderItemDto> items = orderRepository.getItemsWithTotalPrice(orderId);
        return items;
    }

    @PostMapping
    public void sendEmail() {
        EmailNotification emailNotification = EmailNotification.builder()
                .subject("Test")
                .to("cursosderum@gmail.com")
                .body("Hello world")
                .hasTemplate(false)
                .build();
        emailService.send(emailNotification);
    }
}

