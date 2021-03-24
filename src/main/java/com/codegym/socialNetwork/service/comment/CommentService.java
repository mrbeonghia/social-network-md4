package com.codegym.socialNetwork.service.comment;

import com.codegym.socialNetwork.model.Comment;
import com.codegym.socialNetwork.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Override
    public Iterable findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepo.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepo.deleteById(id);
    }
}
