package com.codegym.socialNetwork.service.post;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.service.IService;

public interface IPostService extends IService<Post> {
    Iterable<Post> findAllByUser(AppUser appUser);
}
