package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.Comment;
import com.codegym.socialNetwork.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ModelAttribute("comments")
    public Iterable<Comment> comments(){
        return commentService.findAll();
    }
    @GetMapping("/create-comment")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/comment/create");
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/create-comment")
    public ModelAndView saveComment(@ModelAttribute("comment") Comment comment){
        commentService.save(comment);
        ModelAndView modelAndView = new ModelAndView("/comment/create");
        modelAndView.addObject("comment", new Comment());
        modelAndView.addObject("message", "New comment created successfully");
        return modelAndView;
    }
}
