package com.petadoption.controller;

import com.petadoption.model.AdoptionRequest;
import com.petadoption.model.RequestStatus;
import com.petadoption.repository.AdoptionRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class AdoptionRequestController {

    private final AdoptionRequestRepository adoptionRequestRepository;

    // Προβολή όλων των αιτημάτων (admin panel)
    @GetMapping("/adoption-requests")
    public String viewAdoptionRequests(Model model) {
        model.addAttribute("adoptionRequests", adoptionRequestRepository.findAll());
        return "adoption-requests"; // adoption-requests.html
    }

    // Προβολή φόρμας υποβολής νέου αιτήματος (user)
    @GetMapping("/adoption-requests/new")
    public String showRequestForm(Model model) {
        model.addAttribute("request", new AdoptionRequest());
        return "adoption-request-form"; // adoption-request-form.html
    }

    // Υποβολή νέου αιτήματος (user)
    @PostMapping("/adoption-requests/submit")
    public String submitRequest(@ModelAttribute AdoptionRequest request) {
        request.setStatus(RequestStatus.PENDING);
        request.setRequestDate(LocalDate.now());
        adoptionRequestRepository.save(request);
        return "redirect:/dashboard";
    }

    // Έγκριση αιτήματος (admin)
    @GetMapping("/adoption-requests/approve/{id}")
    public String approveRequest(@PathVariable Long id) {
        AdoptionRequest request = adoptionRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request ID: " + id));
        request.setStatus(RequestStatus.APPROVED);
        adoptionRequestRepository.save(request);
        return "redirect:/adoption-requests";
    }

    // Απόρριψη αιτήματος (admin)
    @GetMapping("/adoption-requests/reject/{id}")
    public String rejectRequest(@PathVariable Long id) {
        AdoptionRequest request = adoptionRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request ID: " + id));
        request.setStatus(RequestStatus.REJECTED);
        adoptionRequestRepository.save(request);
        return "redirect:/adoption-requests";
    }
}
