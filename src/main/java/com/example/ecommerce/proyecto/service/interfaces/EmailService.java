package com.example.ecommerce.proyecto.service.interfaces;


import com.example.ecommerce.proyecto.dto.EmailNotification;

public interface EmailService {

  String send(EmailNotification email);
}
