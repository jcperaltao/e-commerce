package com.example.ecommerce.proyecto.controller;

import com.example.ecommerce.proyecto.dto.AuthenticationRequest;
import com.example.ecommerce.proyecto.dto.AuthenticationResponse;
import com.example.ecommerce.proyecto.dto.RegistrationRequest;
import com.example.ecommerce.proyecto.service.interfaces.AuthenticationService;
import com.example.ecommerce.proyecto.service.interfaces.RegistrationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Juan Carlos Peralta Olivera
 */
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private RegistrationService registrationService;
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequest dto) {
        String message = registrationService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestParam String token) {
        String message = registrationService.confirm(token);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
