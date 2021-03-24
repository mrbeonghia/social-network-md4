package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
