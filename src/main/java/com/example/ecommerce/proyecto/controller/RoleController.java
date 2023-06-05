package com.example.ecommerce.proyecto.controller;

import com.example.ecommerce.proyecto.entity.Role;
import com.example.ecommerce.proyecto.service.interfaces.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Juan Carlos Peralta Olivera
 */
@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    @GetMapping("/name/{name}")
    public ResponseEntity<Role> getByName(@PathVariable String name) {
        Role roleFound = roleService.getByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(roleFound);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll() {
        List<Role> roles = roleService.getAll();
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<Role> save( @RequestBody Role role ) {
        return ResponseEntity.status( HttpStatus.CREATED).body( roleService.save( role ) );
    }

}

