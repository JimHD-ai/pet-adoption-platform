package com.petadoption.controller;

import com.petadoption.model.Pet;
import com.petadoption.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin") // Όλες οι διαδρομές ξεκινούν από /admin
public class PetController {

    @Autowired
    private AdminService adminService;

    // Προβολή όλων των κατοικιδίων
    @GetMapping("/pets")
    public String getAllPets(Model model) {
        List<Pet> pets = adminService.getAllPets();
        model.addAttribute("pets", pets);
        return "admin-pets";
    }

    // Φόρμα προσθήκης νέου κατοικιδίου
    @GetMapping("/pets/add")
    public String showAddPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        return "add-pet";
    }

    // Επεξεργασία κατοικιδίου (φόρμα)
    @GetMapping("/pets/edit/{id}")
    public String editPetForm(@PathVariable Long id, Model model) {
        Pet pet = adminService.getPetById(id);
        model.addAttribute("pet", pet);
        return "edit-pet";
    }

    // Αποθήκευση νέου κατοικιδίου (ή ενημέρωση)
    @PostMapping("/pets/save")
    public String savePet(@ModelAttribute Pet pet) {
        adminService.savePet(pet);
        return "redirect:/admin/pets";
    }

    // Διαγραφή κατοικιδίου
    @PostMapping("/pets/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        adminService.deletePet(id);
        return "redirect:/admin/pets";
    }
}
