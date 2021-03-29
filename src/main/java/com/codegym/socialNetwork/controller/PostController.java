package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
@Controller
@RequestMapping("/posts/create")
public class PostController {

    @Autowired
    private Environment environment;

    @Autowired
    private IPostService postService;

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

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Post post) throws IOException {
        upLoadFile(post);
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("post/create", "posts", new Post());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("post/edit");
        Optional<Post> post = postService.findById(id);
        modelAndView.addObject("comment", post);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@RequestParam Long id, @ModelAttribute Post post) throws IOException{
        upLoadFile(post);
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
