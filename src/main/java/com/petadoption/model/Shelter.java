package com.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Το καταφύγιο είναι επίσης χρήστης. Μπορεί να καταχωρεί κατοικίδια και να εγκρίνει αιτήσεις.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)


public class Shelter extends AppUser {

    private String name;     // Όνομα καταφυγίου
    private String address;  // Διεύθυνση
    private String phone;    // Τηλέφωνο επικοινωνίας
}
