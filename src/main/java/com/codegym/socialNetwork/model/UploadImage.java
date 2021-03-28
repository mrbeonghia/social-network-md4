package com.codegym.socialNetwork.model;

import javax.persistence.*;

@Entity
public class UploadImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Post post;
}
