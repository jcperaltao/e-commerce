package com.example.ecommerce.proyecto.service.interfaces;

import com.example.ecommerce.proyecto.entity.Role;

import java.util.List;

public interface RoleService {
  Role getByName(String name);

  List<Role> getAll();

  Role save(Role role);
}
