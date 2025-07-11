package com.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Η βασική κλάση για όλους τους χρήστες του συστήματος.
 * Γίνεται extend από Citizen, Shelter, Veterinarian.
 */
@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED) // Επιτρέπει την κληρονομικότητα στις υποκλάσεις
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Πρωτεύον κλειδί

    @Column(nullable = false, unique = true)
    private String username; // Όνομα χρήστη (login)

    @Column(nullable = false)
    private String password; // Κρυπτογραφημένος κωδικός

    @Column(nullable = false, unique = true)
    private String email; // Email του χρήστη (μοναδικό)

    @ManyToOne // Πολλοί χρήστες μπορούν να έχουν τον ίδιο ρόλο
    @JoinColumn(name = "role_id")
    private Role role; // Ο ρόλος του χρήστη (σχέση με Role)
}
