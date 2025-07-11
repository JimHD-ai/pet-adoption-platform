package com.petadoption.repository;

import com.petadoption.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    // Βρες χρήστη βάσει username
    Optional<AppUser> findByUsername(String username);

    // Έλεγχος ύπαρξης username
    boolean existsByUsername(String username);

    // Έλεγχος ύπαρξης email
    boolean existsByEmail(String email);
}
