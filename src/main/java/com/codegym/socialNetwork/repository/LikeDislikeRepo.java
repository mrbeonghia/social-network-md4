package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.LikeDislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDislikeRepo extends JpaRepository<LikeDislike, Long> {
}
