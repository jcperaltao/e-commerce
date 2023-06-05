package com.example.ecommerce.proyecto.service.implement;

import com.example.ecommerce.proyecto.dto.AuthenticationRequest;
import com.example.ecommerce.proyecto.dto.AuthenticationResponse;
import com.example.ecommerce.proyecto.entity.User;
import com.example.ecommerce.proyecto.security.jwt.JwtService;
import com.example.ecommerce.proyecto.service.interfaces.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  private AuthenticationManager authenticationManager;

  private JwtService jwtService;

  @Override
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    Authentication auth = new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword());
    Authentication authResult = authenticationManager.authenticate(auth);
    User user = (User) authResult.getPrincipal();
    String accessToken = jwtService.createToken(user);
    return AuthenticationResponse.builder()
        .accessToken(accessToken)
        .build();
  }
}
