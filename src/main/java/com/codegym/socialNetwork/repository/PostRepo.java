package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post , Long> {
    Iterable<Post> findAllByAppUserOrderById(AppUser appUser);
}
