package com.example.ecommerce.proyecto.repository;


import com.example.ecommerce.proyecto.entity.Role;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

  /*
  @Query(value="SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
  Role findRoleByName(String name);

  @Query("SELECT r FROM Role r WHERE r.name = ?1")
  Role getRoleByName(String name);
  */

  Optional<Role> findByName(String name);


    @Query (value = " select * " +
            "from roles " +
            "where name = ?1 ",nativeQuery = true)
    JSONObject findRoleByName(String name);
}
