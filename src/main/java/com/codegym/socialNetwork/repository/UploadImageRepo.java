package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.UploadImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UploadImageRepo extends CrudRepository<UploadImage, Long> {
    @Query(value = "select * from images", nativeQuery = true)
    Iterable<UploadImage> findAll();
}
