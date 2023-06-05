package com.example.ecommerce.proyecto.mapper;

import com.example.ecommerce.proyecto.dto.PageDto;
import com.example.ecommerce.proyecto.dto.ProductDto;
import com.example.ecommerce.proyecto.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * @author Juan Carlos Peralta Olivera
 */

@Component
public class ProductMapper {

    public Product fromDto(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setImageUrl(dto.getImageUrl());
        product.setActive(dto.isActive());
        return product;
    }

    public PageDto<Product> fromEntity(Page<Product> page) {
        PageDto<Product> dto = new PageDto<>();
        dto.setContent(page.getContent());
        dto.setLast(page.isLast());
        dto.setPageNumber(page.getNumber());
        dto.setPageSize(page.getSize());
        dto.setTotalPages(page.getTotalPages());
        dto.setTotalElements(page.getTotalElements());
        return dto;
    }

}
