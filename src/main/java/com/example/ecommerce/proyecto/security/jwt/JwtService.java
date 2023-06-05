package com.example.ecommerce.proyecto.security.jwt;


import com.example.ecommerce.proyecto.entity.User;

public interface JwtService {

  String createToken(User user);

  User decodeToken(String token);

}
