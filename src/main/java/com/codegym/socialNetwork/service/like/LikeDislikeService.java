package com.codegym.socialNetwork.service.like;

import com.codegym.socialNetwork.model.LikeDislike;
import com.codegym.socialNetwork.repository.LikeDislikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LikeDislikeService implements ILikeDislikeService {

    @Autowired
    private LikeDislikeRepo likeDislikeRepo;

    @Override
    public Iterable<LikeDislike> findAll() {
        return likeDislikeRepo.findAll();
    }

    @Override
    public Optional<LikeDislike> findById(Long id) {
        return likeDislikeRepo.findById(id);
    }

    @Override
    public void save(LikeDislike likeDislike) {
        likeDislikeRepo.save(likeDislike);
    }

    @Override
    public void remove(Long id) {
        likeDislikeRepo.deleteById(id);
    }
}
