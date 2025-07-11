package com.petadoption.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // αντιστοιχεί στο login.html μέσα στα templates
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "redirect:/login?logout";
    }
}
