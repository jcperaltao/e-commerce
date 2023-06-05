package com.example.ecommerce.proyecto.service.interfaces;


import com.example.ecommerce.proyecto.dto.UserDto;
import com.example.ecommerce.proyecto.entity.User;

import java.util.UUID;

public interface UserService {

  UserDto getById(UUID id);

  User create(User user);

  boolean existEmail(String email);

  User getByEmail(String email);

  void enableUser(User user);
}
