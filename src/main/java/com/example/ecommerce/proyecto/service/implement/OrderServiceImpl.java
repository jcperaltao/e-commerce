package com.example.ecommerce.proyecto.service.implement;

import com.example.ecommerce.proyecto.dto.OrderDto;
import com.example.ecommerce.proyecto.entity.Order;
import com.example.ecommerce.proyecto.entity.OrderItem;
import com.example.ecommerce.proyecto.entity.User;
import com.example.ecommerce.proyecto.exception.EntityNotFoundException;
import com.example.ecommerce.proyecto.repository.OrderRepository;
import com.example.ecommerce.proyecto.service.interfaces.OrderService;
import com.example.ecommerce.proyecto.service.interfaces.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

  private ProductService productService;
  private OrderRepository orderRepository;

  @Override
  public String create(OrderDto dto) {

    Order order = new Order();
    order.setComment(dto.getComment());

    List<OrderItem> items = dto.getItems().stream().map((itemDto) -> {
      OrderItem item = new OrderItem();
      item.setQuantity(itemDto.getQuantity());
      item.setProduct(productService.getById(itemDto.getProductId()));
      item.setOrder(order);
      return item;
    }).toList();

    order.setItems(items);

    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    order.setUser(user);

    Order orderSaved = orderRepository.save(order);

    return "Order saved successfully";
  }

  @Override
  public OrderDto getById(UUID id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Order", id));

    OrderDto orderDto = new OrderDto();
    orderDto.setComment(order.getComment());
    orderDto.setState(order.getState());
    orderDto.setTotalPrice(orderRepository.getTotalPrice(id));
    orderDto.setItems(orderRepository.getItemsWithTotalPrice(id));

    return orderDto;
  }
}
