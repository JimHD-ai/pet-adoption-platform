package com.petadoption.service;

import com.petadoption.model.Pet;
import java.util.List;

public interface PetService {
    List<Pet> getAllAvailablePets();
    long countPets();
}
