package com.example.ecommerce.proyecto.controller;

import com.example.ecommerce.proyecto.dto.UserDto;
import com.example.ecommerce.proyecto.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Juan Carlos Peralta Olivera
 */
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable UUID id) {
        ;
        return ResponseEntity.ok(userService.getById(id));
    }
}
