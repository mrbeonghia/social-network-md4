package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new AppUser());
        return modelAndView;
    }
}
