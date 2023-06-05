package com.example.ecommerce.proyecto.service.interfaces;


import com.example.ecommerce.proyecto.dto.AuthenticationRequest;
import com.example.ecommerce.proyecto.dto.AuthenticationResponse;

public interface AuthenticationService {

  AuthenticationResponse authenticate(AuthenticationRequest request);

}
