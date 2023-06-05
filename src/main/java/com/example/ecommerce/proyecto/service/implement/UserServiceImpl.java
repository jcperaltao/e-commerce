package com.example.ecommerce.proyecto.service.implement;


import com.example.ecommerce.proyecto.dto.UserDto;
import com.example.ecommerce.proyecto.entity.User;
import com.example.ecommerce.proyecto.exception.EntityNotFoundException;
import com.example.ecommerce.proyecto.repository.UserRepository;
import com.example.ecommerce.proyecto.service.interfaces.UserService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Override
  public UserDto getById(UUID id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User", id));

    UserDto dto = new UserDto();
    dto.setId(user.getId());
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getLastName());
    dto.setEmail(user.getEmail());
    dto.setAddress(user.getAddress());
    dto.setRoleName(user.getRole().getName());

    return dto;
  }

  @Override
  public User create(User user) {
    return userRepository.save(user);
  }

  @Override
  public boolean existEmail(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  @Override
  public User getByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new EntityNotFoundException(
            String.format("User with email %s not found", email)));
  }

  @Override
  public void enableUser(User user) {
    user.setEnable(true);
    userRepository.save(user);
  }


}
