package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.service.post.IPostService;
import com.codegym.socialNetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    IUserService userService;

    @Autowired
    IPostService postService;

    @Autowired
    private Environment environment;

    @ModelAttribute()
    public AppUser currentUser() {
        return userService.getCurrentUser();
    }

    @PostMapping("/posts/create")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        String context = post.getContext();
        Post post1 = new Post();
        post1.setContext(context);
        post1.setStatus(post.getStatus());
        post1.setAppUser(currentUser());
        postService.save(post1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Iterable<Post>> listPost(@PathVariable Long id) {
        AppUser appUser = userService.findById(id).get();
        Iterable<Post> posts = postService.findAllByUser(appUser);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    private void upLoadFile(@ModelAttribute Post post) throws IOException {
        MultipartFile multipartFile = post.getImageMul();
        String imageName = multipartFile.getOriginalFilename();
        String resource = environment.getProperty("upload.path");
        String newImage = resource + imageName;
        FileCopyUtils.copy(multipartFile.getBytes(), new File(newImage));
        post.setImagePost(imageName);
    }

    @GetMapping("/create")
    public ModelAndView ShowFormCreate() {
        ModelAndView modelAndView = new ModelAndView("post/create");
        modelAndView.addObject("posts", new Post());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("post/edit");
        Optional<Post> post = postService.findById(id);
        modelAndView.addObject("comment", post);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@RequestParam Long id, @ModelAttribute Post post) throws IOException {
        upLoadFile(post);
        post.setId(id);
        postService.save(post);
        return new ModelAndView("redirect:/posts");
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id) {
        postService.remove(id);
        return new ModelAndView("redirect:/posts");
    }
}
