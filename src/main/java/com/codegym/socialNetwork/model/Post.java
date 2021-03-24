package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imagePost;

    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private String Image;

    @ManyToOne
    private AppUser appUser;
}
