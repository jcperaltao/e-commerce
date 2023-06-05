package com.example.ecommerce.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {

  private Integer quantity;
  private UUID productId;

  @JsonProperty(access = Access.READ_ONLY)
  private Double totalPrice;

  public OrderItemDto(UUID productId, Integer quantity, Double totalPrice) {
    this.quantity = quantity;
    this.productId = productId;
    this.totalPrice = totalPrice;
  }
}
