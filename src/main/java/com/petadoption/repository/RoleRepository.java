package com.petadoption.repository;

import com.petadoption.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name); // π.χ. "ADMIN", "User"
}
