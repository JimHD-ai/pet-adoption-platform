package com.petadoption.testdata;

import com.petadoption.model.*;
import com.petadoption.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TestDataLoader {

    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private PetRepository petRepository;
    @Autowired private ShelterRepository shelterRepository;
    @Autowired private VeterinarianRepository veterinarianRepository;
    @Autowired private AdoptionRequestRepository adoptionRequestRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadData() {

        // Διαγραφή όλων των δεδομένων (σωστή σειρά λόγω foreign keys)
        adoptionRequestRepository.deleteAll();
        petRepository.deleteAll();
        shelterRepository.deleteAll();
        veterinarianRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();

        // --- ΡΟΛΟΙ ---
        Role adminRole = new Role(null, "ADMIN");
        Role userRole = new Role(null, "USER");
        roleRepository.saveAll(List.of(adminRole, userRole));

        // --- ΧΡΗΣΤΕΣ ---
        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setEmail("admin@example.com");
        admin.setRole(adminRole);
        userRepository.save(admin);

        AppUser user = new AppUser();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setEmail("user@example.com");
        user.setRole(userRole);
        userRepository.save(user);

        // --- ΚΑΤΑΦΥΓΙΑ ---
        Shelter shelter1 = new Shelter();
        shelter1.setUsername("athens_shelter");
        shelter1.setPassword(passwordEncoder.encode("shelter123"));
        shelter1.setEmail("athens@shelters.com");
        shelter1.setRole(userRole); // Αν έχεις ειδικό ρόλο, βάλε τον εδώ
        shelter1.setName("Athens Shelter");
        shelter1.setAddress("Athens");
        shelter1.setPhone("2100000001");

        Shelter shelter2 = new Shelter();
        shelter2.setUsername("thess_shelter");
        shelter2.setPassword(passwordEncoder.encode("shelter123"));
        shelter2.setEmail("thess@shelters.com");
        shelter2.setRole(userRole);
        shelter2.setName("Thessaloniki Shelter");
        shelter2.setAddress("Thessaloniki");
        shelter2.setPhone("2310000002");

        shelterRepository.saveAll(List.of(shelter1, shelter2));

        // --- ΚΤΗΝΙΑΤΡΟΙ ---
        Veterinarian vet1 = new Veterinarian();
        vet1.setUsername("eleni");
        vet1.setPassword(passwordEncoder.encode("vet123"));
        vet1.setEmail("eleni@vets.com");
        vet1.setRole(userRole);
        vet1.setName("Dr. Eleni");
        vet1.setLicenseNumber("VET123");
        vet1.setContactInfo("2101234567");

        Veterinarian vet2 = new Veterinarian();
        vet2.setUsername("nikos");
        vet2.setPassword(passwordEncoder.encode("vet123"));
        vet2.setEmail("nikos@vets.com");
        vet2.setRole(userRole);
        vet2.setName("Dr. Nikos");
        vet2.setLicenseNumber("VET456");
        vet2.setContactInfo("2107654321");

        veterinarianRepository.saveAll(List.of(vet1, vet2));

        // --- ΚΑΤΟΙΚΙΔΙΑ ---
        Pet pet1 = new Pet();
        pet1.setName("Rex");
        pet1.setSpecies("Dog");
        pet1.setBreed("Labrador");
        pet1.setAge(3);
        pet1.setHealthStatus("Healthy");
        //pet1.setStatus("AVAILABLE"); // status είναι String, οπότε ΟΚ
        pet1.setAdoptionStatus(AdoptionStatus.AVAILABLE); // enum
        pet1.setShelter(shelter1);
        pet1.setVeterinarian(vet1);

        Pet pet2 = new Pet();
        pet2.setName("Milo");
        pet2.setSpecies("Cat");
        pet2.setBreed("Siamese");
        pet2.setAge(2);
        pet2.setHealthStatus("Healthy");
       // pet2.setStatus("ADOPTED");
        pet2.setAdoptionStatus(AdoptionStatus.ADOPTED);
        pet2.setShelter(shelter2);
        pet2.setVeterinarian(vet2);

        petRepository.saveAll(List.of(pet1, pet2));

        // --- ΑΙΤΗΜΑ ΥΙΟΘΕΣΙΑΣ ---
        AdoptionRequest request = new AdoptionRequest();
        request.setUser(user);
        request.setPet(pet1);

        
        // request.setDate(LocalDate.now()); 
        request.setRequestDate(LocalDate.now()); 

        request.setStatus(RequestStatus.PENDING); // enum, ΟΧΙ String!

        adoptionRequestRepository.save(request);

        System.out.println("Test data loaded!");
    }
}
