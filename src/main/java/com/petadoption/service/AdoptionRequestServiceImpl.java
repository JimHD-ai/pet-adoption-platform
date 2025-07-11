package com.petadoption.service;

import com.petadoption.model.AdoptionRequest;
import com.petadoption.repository.AdoptionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionRequestServiceImpl implements AdoptionRequestService {

    @Autowired
    private AdoptionRequestRepository adoptionRequestRepository;

    @Override
    public List<AdoptionRequest> getRequestsByUserId(Long userId) {
        return adoptionRequestRepository.findByUserId(userId);
    }

    @Override
    public AdoptionRequest createRequest(AdoptionRequest request) {
        return adoptionRequestRepository.save(request);
    }
}
