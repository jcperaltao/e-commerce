package com.example.ecommerce.proyecto.service.interfaces;


import com.example.ecommerce.proyecto.entity.ConfirmationToken;

public interface ConfirmationTokenService {

  ConfirmationToken create(ConfirmationToken confirmationToken);

  ConfirmationToken getByToken(String token);

  void setConfirmedAt(ConfirmationToken confirmationToken);
}
