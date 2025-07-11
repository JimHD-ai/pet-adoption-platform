package com.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdoptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Ή "app_user_id" αν έτσι λέγεται το table σου
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private LocalDate date;
    private LocalDate requestDate;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}
