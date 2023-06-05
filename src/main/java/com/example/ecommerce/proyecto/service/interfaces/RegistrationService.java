package com.example.ecommerce.proyecto.service.interfaces;


import com.example.ecommerce.proyecto.dto.RegistrationRequest;

public interface RegistrationService {

  String register(RegistrationRequest dto);

  String confirm(String token);
}
