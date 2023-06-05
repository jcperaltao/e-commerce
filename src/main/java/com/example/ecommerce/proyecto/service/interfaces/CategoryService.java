package com.example.ecommerce.proyecto.service.interfaces;



import com.example.ecommerce.proyecto.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

  Category getById(UUID id);

  List<Category> getAll();
}
