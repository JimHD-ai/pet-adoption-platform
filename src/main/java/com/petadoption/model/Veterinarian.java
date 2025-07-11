package com.petadoption.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Veterinarian extends AppUser {

    private String name;           
    private String licenseNumber;  
    private String contactInfo;    
    
}
