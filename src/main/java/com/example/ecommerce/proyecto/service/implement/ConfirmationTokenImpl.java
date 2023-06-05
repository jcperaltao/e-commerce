package com.example.ecommerce.proyecto.service.implement;


import com.example.ecommerce.proyecto.entity.ConfirmationToken;
import com.example.ecommerce.proyecto.repository.ConfirmationTokenRepository;
import com.example.ecommerce.proyecto.service.interfaces.ConfirmationTokenService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ConfirmationTokenImpl implements ConfirmationTokenService {

  private ConfirmationTokenRepository repository;

  @Override
  public ConfirmationToken create(ConfirmationToken confirmationToken) {
    return repository.save(confirmationToken);
  }

  @Override
  public ConfirmationToken getByToken(String token) {
    return repository.findByToken(token)
        .orElseThrow(() -> new EntityNotFoundException("Confirmation token not found"));
  }

  @Override
  public void setConfirmedAt(ConfirmationToken confirmationToken) {
    confirmationToken.setConfirmedAt(LocalDateTime.now());
    repository.save(confirmationToken);
  }
}
