package com.codegym.socialNetwork.service.UploadImageService;

import com.codegym.socialNetwork.model.UploadImage;
import com.codegym.socialNetwork.repository.UploadImageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UploadImageService implements IUploadImageService {

    @Autowired
    private UploadImageRepo uploadImageRepo;
    @Override
    public Iterable<UploadImage> findAll() {
        return uploadImageRepo.findAll();
    }

    @Override
    public Optional<UploadImage> findById(Long id) {
        return uploadImageRepo.findById(id);
    }

    @Override
    public void save(UploadImage uploadImage) {
        uploadImageRepo.save(uploadImage);
    }

    @Override
    public void remove(Long id) {
        uploadImageRepo.deleteById(id);
    }
}
