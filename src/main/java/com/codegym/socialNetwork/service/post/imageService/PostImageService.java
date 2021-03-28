package com.codegym.socialNetwork.service.post.imageService;

import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.model.PostImage;
import com.codegym.socialNetwork.repository.PostImageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostImageService implements IPostImageService{

    @Autowired
    private PostImageRepo postImageRepo;
    @Override
    public Iterable<PostImage> findAll() {
        return postImageRepo.findAll();
    }

    @Override
    public Optional<PostImage> findById(Long id) {
        return postImageRepo.findById(id);
    }

    @Override
    public void save(PostImage postImage) {
        postImageRepo.save(postImage);
    }

    @Override
    public void remove(Long id) {
        postImageRepo.deleteById(id);
    }

    @Override
    public Iterable<PostImage> findPostImageByPost(Post post) {
        return postImageRepo.findAll();
    }
}
