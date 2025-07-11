package com.petadoption.controller;

import com.petadoption.model.AdoptionRequest;
import com.petadoption.model.AppUser;
import com.petadoption.model.Pet;
import com.petadoption.security.CustomUserDetails;
import com.petadoption.service.AdoptionRequestService;
import com.petadoption.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PetService petService;

    @Autowired
    private AdoptionRequestService adoptionRequestService;

    // dashboard με username
    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        AppUser user = userDetails.getUser(); // ή getAppUser() ανάλογα με τη μέθοδό σου
        model.addAttribute("username", user.getUsername());
        return "dashboard";
    }

    // λίστα κατοικιδίων διαθέσιμων για υιοθεσία
    @GetMapping("/pets")
    public String viewAvailablePets(Model model) {
        List<Pet> pets = petService.getAllAvailablePets();
        model.addAttribute("pets", pets);
        return "pets";
    }

    // λίστα με τα δικά σου αιτήματα υιοθεσίας
    @GetMapping("/my-requests")
    public String viewUserRequests(Authentication authentication, Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        AppUser user = userDetails.getUser();
        List<AdoptionRequest> myRequests = adoptionRequestService.getRequestsByUserId(user.getId());
        model.addAttribute("adoptionRequests", myRequests);
        return "adoption-requests";
    }
}
