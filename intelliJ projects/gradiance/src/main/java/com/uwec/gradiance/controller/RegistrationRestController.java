package com.uwec.gradiance.controller;

import com.uwec.gradiance.model.RegistrationRequest;
import com.uwec.gradiance.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationRestController {
    private final RegistrationService regService;
    public RegistrationRestController(RegistrationService regService) {
        this.regService = regService;
    }

    @PostMapping("/register")
    public String processRegistration(
            @ModelAttribute("registrationRequest")
            @Valid RegistrationRequest request,
            BindingResult errors,
            Model model
    ) {
        regService.register(request, errors);
        System.out.println("registration mapping");
        if (errors.hasErrors()) {
            // errors will be rendered on the form
            return "register";
        }

        // on success, redirect with a flash parameter
        return "redirect:/login?registered";
    }
}
