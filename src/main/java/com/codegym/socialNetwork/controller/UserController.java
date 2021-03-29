package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.AppUserForm;
import com.codegym.socialNetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    Environment environment;

    @ModelAttribute("user")
    public AppUser appUser(){
        return userService.getCurrentUser();
    }

    @GetMapping("/{id}")
    public ModelAndView getUserInfo(@PathVariable("id") Long id){
        AppUser user = userService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable("id") Long id){
        AppUser user = userService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("editUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/edit")
    public RedirectView editUser( @ModelAttribute AppUserForm userForm){
//        AppUser user = new AppUser(userForm.getFirstName(),userForm.getLastName(),userForm.getEmail(),userForm.getPhoneNumber(),userForm.getGender(),userForm.getDateOfBirth(), userForm.getUsername(), userForm.getPassword());
        AppUser user = userService.findById(userForm.getId()).get();
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setGender(userForm.getGender());
        user.setDateOfBirth(userForm.getDateOfBirth());
        MultipartFile multipartFile = userForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(userForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        user.setAvatar(fileName);
        userService.save(user);
        return new RedirectView("");
    }
}
