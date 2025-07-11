package com.petadoption.repository;

import com.petadoption.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    Optional<Veterinarian> findByUsername(String username);
}
