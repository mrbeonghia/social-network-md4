package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private LikeDislike likeDislike;

    @OneToOne
    private AppUser appUser;
}
