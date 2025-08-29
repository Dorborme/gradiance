package com.uwec.gradiance.controller;

import com.uwec.gradiance.database.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.uwec.gradiance.model.LoginRequest;
import com.uwec.gradiance.service.UserService;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(Model model) {
        System.out.println("Login Page");
        model.addAttribute("LoginRequest", new LoginRequest());
        System.out.println("returning login");
        return "login";
    }

}
