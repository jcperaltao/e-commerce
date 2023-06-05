package com.example.ecommerce.proyecto.service.implement;


import com.example.ecommerce.proyecto.entity.Category;
import com.example.ecommerce.proyecto.exception.EntityNotFoundException;
import com.example.ecommerce.proyecto.repository.CategoryRepository;
import com.example.ecommerce.proyecto.service.interfaces.CategoryService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepository categoryRepository;

  @Override
  public Category getById(UUID id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Category", id));
    return category;
  }

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }
}
