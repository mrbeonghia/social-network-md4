package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LikeDislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Comment comment;

    @OneToOne
    private AppUser appUser;

    private boolean isLiked;

    public boolean isLiked(){
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
