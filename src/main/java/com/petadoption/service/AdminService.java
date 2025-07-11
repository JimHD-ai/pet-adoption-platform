package com.petadoption.service;

import org.springframework.stereotype.Service;
import java.util.List;
import lombok.RequiredArgsConstructor;
import com.petadoption.model.AppUser;
import com.petadoption.model.Pet;
import com.petadoption.model.Role;
import com.petadoption.model.Shelter;
import com.petadoption.model.Veterinarian;
import com.petadoption.model.AdoptionRequest;
import com.petadoption.model.RequestStatus;
import com.petadoption.repository.UserRepository;
import com.petadoption.repository.PetRepository;
import com.petadoption.repository.RoleRepository;
import com.petadoption.repository.ShelterRepository;
import com.petadoption.repository.VeterinarianRepository;
import com.petadoption.repository.AdoptionRequestRepository;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final RoleRepository roleRepository;
    private final AdoptionRequestRepository adoptionRequestRepository;
    private final ShelterRepository shelterRepository;
    private final VeterinarianRepository veterinarianRepository;

    // ----- Users -----
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // ----- Pets -----
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    public Pet getPetById(Long id) {
    return petRepository.findById(id).orElse(null);
}


    public void deletePet(Long petId) {
        petRepository.deleteById(petId);
    }

    // ----- Roles -----
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    // ----- Adoption Requests -----
    public List<AdoptionRequest> getAllAdoptionRequests() {
        return adoptionRequestRepository.findAll();
    }

    public void approveRequest(Long id) {
        AdoptionRequest req = adoptionRequestRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        req.setStatus(RequestStatus.APPROVED);
        adoptionRequestRepository.save(req);
    }

    public void rejectRequest(Long id) {
        AdoptionRequest req = adoptionRequestRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
        req.setStatus(RequestStatus.REJECTED);
        adoptionRequestRepository.save(req);
    }

    // ----- Shelters -----
    public List<Shelter> getAllShelters() {
        return shelterRepository.findAll();
    }

    // ----- Veterinarians -----
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    public long countUsers() {
        return userRepository.count();
    }

    public long countPets() {
        return petRepository.count();
    }

    public long countAdoptionRequests() {
        return adoptionRequestRepository.count();
    }

}
