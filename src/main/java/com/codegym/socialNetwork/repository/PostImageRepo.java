package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.PostImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostImageRepo extends CrudRepository<PostImage, Long> {
    @Query(value = "select * from images", nativeQuery = true)
    Iterable<PostImage> findAll();
}
