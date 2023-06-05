package com.example.ecommerce.proyecto.service.implement;


import com.example.ecommerce.proyecto.entity.Role;
import com.example.ecommerce.proyecto.exception.RoleConflictException;
import com.example.ecommerce.proyecto.repository.RoleRepository;
import com.example.ecommerce.proyecto.service.interfaces.RoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
  }

  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  public Role save(Role role) {
    if(roleRepository.findByName( role.getName() ).isEmpty()){
      return roleRepository.save( role );
    }
    throw new RoleConflictException( role.getName() );
  }
}
