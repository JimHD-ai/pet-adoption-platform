package com.petadoption.model;

/**
 * Κατάσταση ενός κατοικιδίου.
 * Πρέπει να συμφωνεί ακριβώς με τα επιτρεπτά values του constraint στη βάση!
 */
public enum AdoptionStatus {
    PENDING,
    APPROVED,
    ADOPTED,
    REJECTED,
    AVAILABLE
}
