package com.example.ecommerce.proyecto.service.interfaces;


import com.example.ecommerce.proyecto.dto.PageDto;
import com.example.ecommerce.proyecto.dto.ProductDto;
import com.example.ecommerce.proyecto.entity.Product;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProductService {

  Product create(ProductDto dto);

  Product getById(UUID id);

  Page<Product> getProducts(Pageable pageable);

  PageDto<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable);

  Product updateProductById(UUID id, ProductDto productDto);

  List<JSONObject> getProductsByCategoryId(UUID id);


}
