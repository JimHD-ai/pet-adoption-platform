package com.petadoption.service;

import com.petadoption.model.AdoptionStatus;
import com.petadoption.model.Pet;
import com.petadoption.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> getAllAvailablePets() {
        return petRepository.findByAdoptionStatus(AdoptionStatus.AVAILABLE);
    }

    @Override
    public long countPets() {
        return petRepository.count();
    }
}
