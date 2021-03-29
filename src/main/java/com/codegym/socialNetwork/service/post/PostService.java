package com.codegym.socialNetwork.service.post;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostService implements IPostService{

    @Autowired
    private PostRepo postRepo;

    @Override
    public Iterable<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepo.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Iterable<Post> findAllByUser(AppUser appUser) {
        return postRepo.findAllByAppUserOrderById(appUser);
    }
}
