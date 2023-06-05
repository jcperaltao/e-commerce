package com.example.ecommerce.proyecto.controller;

import com.example.ecommerce.proyecto.entity.Category;
import com.example.ecommerce.proyecto.service.interfaces.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Juan Carlos Peralta Olivera
 */
@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable UUID id) {
        Category categoryFound = categoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryFound);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
