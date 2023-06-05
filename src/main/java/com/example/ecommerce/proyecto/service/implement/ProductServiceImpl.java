package com.example.ecommerce.proyecto.service.implement;


import com.example.ecommerce.proyecto.dto.PageDto;
import com.example.ecommerce.proyecto.dto.ProductDto;
import com.example.ecommerce.proyecto.entity.Category;
import com.example.ecommerce.proyecto.entity.Product;
import com.example.ecommerce.proyecto.exception.EntityNotFoundException;
import com.example.ecommerce.proyecto.mapper.ProductMapper;
import com.example.ecommerce.proyecto.repository.ProductRepository;
import com.example.ecommerce.proyecto.service.interfaces.CategoryService;
import com.example.ecommerce.proyecto.service.interfaces.ProductService;

import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;
  private CategoryService categoryService;

  private ProductMapper productMapper;

  @Override
  public Product create(ProductDto dto) {
    Category category = categoryService.getById(dto.getCategoryId());
    Product product = productMapper.fromDto(dto);
    product.setCategory(category);
    return productRepository.save(product);
  }

  @Override
  public Product getById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product", id));
  }

  @Override
  public Page<Product> getProducts(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public PageDto<Product> getFilteredProducts(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    return productMapper.fromEntity(page);
  }

  @Override
  public Product updateProductById(UUID id, ProductDto productDto) {
    Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product", id));
    Product productUpdated = new Product();
    productUpdated.setId(id);
    productUpdated.setName(productDto.getName());
    productUpdated.setDescription(productDto.getDescription());
    productUpdated.setActive(true);
    productUpdated.setPrice(productDto.getPrice());
    Category category = categoryService.getById(productDto.getCategoryId());
    productUpdated.setCategory(category);
    productUpdated.setImageUrl(productDto.getImageUrl());
    productUpdated.setStock(productDto.getStock());
    productRepository.save(productUpdated);
    return productUpdated;
  }

  @Override
  public List<JSONObject> getProductsByCategoryId(UUID id) {
    return  productRepository.getProductsByCategoryId(id.toString());
  }


}
