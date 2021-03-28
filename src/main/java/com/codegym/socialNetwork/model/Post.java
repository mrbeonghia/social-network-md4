package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contextPost;

    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private int status;

    @ManyToOne
    private AppUser appUser;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    @OneToMany
    private Set<PostImage> postImage;
}
