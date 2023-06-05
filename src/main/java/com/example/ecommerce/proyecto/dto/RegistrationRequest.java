package com.example.ecommerce.proyecto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationRequest {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String address;
}
