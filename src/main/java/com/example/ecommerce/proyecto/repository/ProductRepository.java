package com.example.ecommerce.proyecto.repository;


import com.example.ecommerce.proyecto.entity.Product;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

  Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

  @Query(value =  "SELECT p.id, p.name, p.description, p.price, p.stock, p.image_url, p.active, c.name as category\n" +
                  "FROM backpack_ecommerce_db.products p\n" +
                  "  INNER JOIN backpack_ecommerce_db.categories c ON p.category_id = c.id\n" +
                  "WHERE c.id = ?1", nativeQuery = true)
  List<JSONObject> getProductsByCategoryId(String id);



}
