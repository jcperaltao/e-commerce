package com.example.ecommerce.proyecto.repository;


import com.example.ecommerce.proyecto.dto.OrderItemDto;
import com.example.ecommerce.proyecto.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

  @Query(value = "SELECT SUM(products.price * order_items.quantity) "
      + "FROM orders "
      + "JOIN order_items ON orders.id = order_items.order_id "
      + "JOIN products ON order_items.product_id = products.id "
      + "WHERE orders.id = ?1", nativeQuery = true)
  Double getTotalPriceByOrderId(String orderId);

  @Query(value = "SELECT SUM(products.price * order_items.quantity) "
          + "FROM orders "
          + "JOIN order_items ON orders.id = order_items.order_id "
          + "JOIN products ON order_items.product_id = products.id "
          + "WHERE orders.id = ?1", nativeQuery = true)
  Double getTotalPrice(UUID orderId);

  @Query(value = "SELECT products.id, order_items.quantity, (products.price * order_items.quantity) "
          + "FROM orders "
          + "JOIN order_items ON orders.id = order_items.order_id "
          + "JOIN products ON order_items.product_id = products.id "
          + "WHERE orders.id = ?1", nativeQuery = true)
  List<OrderItemDto> getItemsWithTotalPrice(UUID orderId);
}
