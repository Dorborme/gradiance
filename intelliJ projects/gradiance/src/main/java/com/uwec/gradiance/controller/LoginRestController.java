package com.uwec.gradiance.controller;

import com.uwec.gradiance.model.LoginRequest;
import com.uwec.gradiance.service.UserService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginRestController {
    private UserService userService;
    public void LoginRestController(UserService userService){this.userService = userService;}


    @PostMapping("/login")
    public String processLogin(
        @ModelAttribute("LoginRequest")
        @Valid LoginRequest lR,
        BindingResult errors,
        Model model) {
            boolean valid;
            System.out.println(lR.getEmail() + lR.getPassword());
            valid = userService.login(lR.getEmail(),lR.getPassword());
            System.out.println(valid);
            if(errors.hasErrors()) {
                return "login";
            }

            if(valid) {
                return "login";
            }
            return "redirect:/login?loggedin";
    }

}