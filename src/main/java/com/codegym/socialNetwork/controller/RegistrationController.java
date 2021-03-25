package com.codegym.socialNetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("/register")
    private String showRegisterForm(){
        return "/register";
    }
}
