package com.petadoption.repository;

import com.petadoption.model.AdoptionRequest;
import com.petadoption.model.Pet;
import com.petadoption.model.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {

    // 1. Βρες όλα τα αιτήματα για συγκεκριμένο κατοικίδιο
    List<AdoptionRequest> findByPet(Pet pet);

    // 2. Βρες όλα τα αιτήματα με βάση status (π.χ. PENDING)
    List<AdoptionRequest> findByStatus(RequestStatus status);

    // 3. Βρες όλα τα αιτήματα με βάση το id του κατοικιδίου
    List<AdoptionRequest> findByPetId(Long petId);

    // 4. Βρες όλα τα εγκεκριμένα αιτήματα
    List<AdoptionRequest> findByStatusOrderByRequestDateDesc(RequestStatus status);

    // 5. Πάρε τα αιτήματα ταξινομημένα κατά ημερομηνία
    List<AdoptionRequest> findAllByOrderByRequestDateDesc();

    // 6. Εύρεση αιτήσεων ανά status και κατοικίδιο
    List<AdoptionRequest> findByPetIdAndStatus(Long petId, RequestStatus status);

    // 7. Υπολογισμός αριθμού αιτήσεων ανά status (για στατιστικά στο dashboard)
    long countByStatus(RequestStatus status);

    // 8. Υπολογισμός αριθμού αιτήσεων για συγκεκριμένο κατοικίδιο
    long countByPet(Pet pet);

    List<AdoptionRequest> findByUserId(Long userId);

}
