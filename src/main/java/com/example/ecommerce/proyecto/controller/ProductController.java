package com.example.ecommerce.proyecto.controller;

import com.example.ecommerce.proyecto.dto.PageDto;
import com.example.ecommerce.proyecto.dto.ProductDto;
import com.example.ecommerce.proyecto.entity.Product;
import com.example.ecommerce.proyecto.service.interfaces.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Juan Carlos Peralta Olivera
 */
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDto dto) {
        Product productSaved = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id) {
        Product productFound = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productFound);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Product>> getProducts(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productService.getProducts(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }

    @GetMapping
    public ResponseEntity<PageDto<Product>> getFilteredProducts(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        if (minPrice == null) {
            minPrice = Double.MIN_VALUE;
        }
        if (maxPrice == null) {
            maxPrice = Double.MAX_VALUE;
        }
        Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        PageDto<Product> productPage = productService.getFilteredProducts(minPrice, maxPrice, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateById(@PathVariable UUID id, @RequestBody ProductDto product) {
        Product productUpdated= productService.updateProductById(id, product);
        return ResponseEntity.status(HttpStatus.OK).body(productUpdated);
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<List<JSONObject>> getProductsByCategoryId(@PathVariable UUID id) {
        List<JSONObject> products = productService.getProductsByCategoryId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}