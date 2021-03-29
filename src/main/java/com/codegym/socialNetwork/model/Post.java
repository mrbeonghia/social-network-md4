package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagePost;

//    @Column(nullable = false)
    private Date datePost;

//    @Column(nullable = false)
    private int status;

    private String context;

    @ManyToOne
    private AppUser appUser;
}
