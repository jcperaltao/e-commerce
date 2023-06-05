package com.example.ecommerce.proyecto.service.interfaces;


import com.example.ecommerce.proyecto.dto.OrderDto;

import java.util.UUID;

public interface OrderService {

  String create(OrderDto order);

  OrderDto getById(UUID id);
}
