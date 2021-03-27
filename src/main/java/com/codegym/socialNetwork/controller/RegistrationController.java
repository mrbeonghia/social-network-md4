package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.service.role.IRoleService;
import com.codegym.socialNetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Stream;

@Controller
public class RegistrationController {
    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IRoleService roleService;

    @GetMapping("/register")
    private ModelAndView showRegisterForm(){
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user",new AppUser());
        return modelAndView;
    }

    @PostMapping("/register")
    private ModelAndView registerNewUser(@ModelAttribute AppUser user){
        ModelAndView modelAndView;
        if(userService.getUserByUsername(user.getUsername()) != null){
            modelAndView = new ModelAndView("register","user",new AppUser());
            modelAndView.addObject("message","User was existed");
            return modelAndView;
        }
        user.setAppRole(roleService.findByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }
}
