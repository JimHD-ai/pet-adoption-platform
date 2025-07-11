package com.petadoption.repository;

import com.petadoption.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    Optional<Shelter> findByUsername(String username);
}
