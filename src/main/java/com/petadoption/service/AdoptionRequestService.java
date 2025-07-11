package com.petadoption.service;

import com.petadoption.model.AdoptionRequest;

import java.util.List;

public interface AdoptionRequestService {
    List<AdoptionRequest> getRequestsByUserId(Long userId);
    AdoptionRequest createRequest(AdoptionRequest request);
}
