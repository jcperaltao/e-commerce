package com.example.ecommerce.proyecto.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

  private UUID id;
  private String firstName;
  private String lastName;
  @Email
  private String email;
  private String address;
  private String roleName;

}
