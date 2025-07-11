package com.petadoption.model;

/**
 * Κατάσταση ενός αιτήματος υιοθεσίας.
 * Χρησιμοποιείται μέσα στο AdoptionRequest entity.
 */
public enum RequestStatus {
    PENDING,
    APPROVED,
    ADOPTED,
    REJECTED,
    AVAILABLE  
}

