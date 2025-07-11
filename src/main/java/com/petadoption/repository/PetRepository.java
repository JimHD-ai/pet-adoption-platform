package com.petadoption.repository;

import com.petadoption.model.Pet;
import com.petadoption.model.AdoptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    // Προβολή όλων των κατοικιδίων με βάση το adoption status
    List<Pet> findByAdoptionStatus(AdoptionStatus status);

    // Πόσα κατοικίδια έχουν συγκεκριμένο adoption status (π.χ. Available)
    long countByAdoptionStatus(AdoptionStatus status);

    // Προβολή κατοικιδίων με βάση είδος
    List<Pet> findBySpecies(String species);

    // Προβολή κατοικιδίων κατά σειρά εισαγωγής
    List<Pet> findAllByOrderByIdDesc();


}
