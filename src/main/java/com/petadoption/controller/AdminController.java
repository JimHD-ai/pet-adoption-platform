package com.petadoption.controller;

import com.petadoption.model.AdoptionRequest;
import com.petadoption.model.AppUser;
import com.petadoption.model.Shelter;
import com.petadoption.model.Veterinarian;
import com.petadoption.service.AdminService;
import com.petadoption.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin Dashboard
    @GetMapping("/dashboard")
    public String adminDashboard(Authentication authentication, Model model) {
        String username = "";
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails) {
            username = userDetails.getUser().getUsername();
        }

        long totalUsers = adminService.countUsers();
        long totalPets = adminService.countPets();
        long totalRequests = adminService.countAdoptionRequests();

        model.addAttribute("username", username);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalPets", totalPets);
        model.addAttribute("totalRequests", totalRequests);

        return "admin-dashboard";
    }

    // -------------------------
    // Χρήστες
    // -------------------------

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<AppUser> users = adminService.getAllUsers();
        model.addAttribute("users", users);
        return "admin-users";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin/users";
    }

    // -------------------------
    // Αιτήματα Υιοθεσίας
    // -------------------------

    @GetMapping("/requests")
    public String getAllRequests(Model model) {
        List<AdoptionRequest> requests = adminService.getAllAdoptionRequests();
        model.addAttribute("requests", requests);
        return "admin-requests";
    }

    @PostMapping("/requests/approve/{id}")
    public String approveRequest(@PathVariable Long id) {
        adminService.approveRequest(id);
        return "redirect:/admin/requests";
    }

    @PostMapping("/requests/reject/{id}")
    public String rejectRequest(@PathVariable Long id) {
        adminService.rejectRequest(id);
        return "redirect:/admin/requests";
    }

    // -------------------------
    // Καταφύγια
    // -------------------------

    @GetMapping("/shelters")
    public String getAllShelters(Model model) {
        List<Shelter> shelters = adminService.getAllShelters();
        model.addAttribute("shelters", shelters);
        return "admin-shelters";
    }

    // -------------------------
    // Κτηνίατροι
    // -------------------------

    @GetMapping("/vets")
    public String getAllVets(Model model) {
        List<Veterinarian> vets = adminService.getAllVeterinarians();
        model.addAttribute("vets", vets);
        return "admin-vets";
    }
}
