package com.codegym.socialNetwork.service.post.imageService;

import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.model.PostImage;
import com.codegym.socialNetwork.service.IService;

public interface IPostImageService extends IService<PostImage> {
    void save(PostImage postImage);
    Iterable<PostImage> findPostImageByPost(Post post);
}
