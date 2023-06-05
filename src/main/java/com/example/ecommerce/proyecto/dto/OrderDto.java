package com.example.ecommerce.proyecto.dto;

import com.example.ecommerce.proyecto.entity.OrderState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

  private String comment;
  private List<OrderItemDto> items;

  @JsonProperty(access = Access.READ_ONLY)
  private Double totalPrice;

  @JsonProperty(access = Access.READ_ONLY)
  private OrderState state;
}
