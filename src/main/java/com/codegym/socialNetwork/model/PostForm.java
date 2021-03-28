package com.codegym.socialNetwork.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class PostForm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contextPost;

    private String imagePost;

    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private int status;

    @ManyToOne
    private AppUser appUser;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();
}
