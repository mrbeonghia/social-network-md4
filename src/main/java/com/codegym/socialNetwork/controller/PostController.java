package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.service.post.IPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
@Controller
@RequestMapping("/posts")
public class PostController {
    private IPostService postService;

    @GetMapping("/create")
    public ModelAndView ShowFormCreate(@ModelAttribute Post post) {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("create", "post", new Post());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showFormEdit(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<Post> post = postService.findById(id);
        modelAndView.addObject("comment", post);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@RequestParam Long id, @ModelAttribute Post post){
        post.setId(id);
        postService.save(post);
        return new ModelAndView("redirect:/posts");
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id){
        postService.remove(id);
        return new ModelAndView("redirect:/posts");
    }
}
