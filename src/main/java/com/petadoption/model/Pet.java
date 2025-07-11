package com.petadoption.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String species;
    private String breed;
    private int age;
    private String healthStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdoptionStatus adoptionStatus = AdoptionStatus.AVAILABLE;

    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Veterinarian veterinarian;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<AdoptionRequest> adoptionRequests = new ArrayList<>();
}
