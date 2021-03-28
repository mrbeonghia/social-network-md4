package com.codegym.socialNetwork.service.UploadImageService;

import com.codegym.socialNetwork.model.UploadImage;
import com.codegym.socialNetwork.service.IService;

public interface IUploadImageService extends IService<UploadImage> {
    void save(UploadImage uploadImage);
}
