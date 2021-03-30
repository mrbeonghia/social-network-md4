package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.model.PostForm;
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
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/posts/{id}")
    public ResponseEntity<Iterable<Post>> listPost(@PathVariable Long id) {
        AppUser appUser = userService.findById(id).get();
        Iterable<Post> posts = postService.findAllByUser(appUser);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ModelAndView ShowFormCreate() {
        ModelAndView modelAndView = new ModelAndView("post/create");
        modelAndView.addObject("posts", new Post());
        return modelAndView;
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

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("post/edit");
        Optional<Post> post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @PostMapping("/edit")
    public RedirectView editPost(@ModelAttribute PostForm postForm) {
        Post post = postService.findById(postForm.getId()).get();
        post.setContextPost(postForm.getContextPost());
        post.setImagePost(postForm.getImagePost());
        post.setDatePost(postForm.getDatePost());
        post.setStatus(postForm.getStatus());
        post.setAppUser(postForm.getAppUser());
        MultipartFile multipartFile = postForm.getImageMul();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(postForm.getImageMul().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        post.setImagePost(fileName);
        postService.save(post);
        return new RedirectView("redirect:/posts");
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id) {
        postService.remove(id);
        return new ModelAndView("redirect:/posts");
    }
}
