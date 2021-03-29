package com.codegym.socialNetwork.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contextPost;

    private String imagePost;

//    @Column(nullable = false)
    private Date datePost;

//    @Column(nullable = false)
    private int status;

    private String context;

    @ManyToOne
    private AppUser appUser;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private MultipartFile imageMul;

}
