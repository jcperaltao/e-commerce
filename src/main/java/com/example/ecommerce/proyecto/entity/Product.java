package com.example.ecommerce.proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  @Column(length = 70, nullable = false)
  private String name;
  private String description;
  private String imageUrl;
  private Double price;
  private Integer stock;
  private Boolean active;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

}
