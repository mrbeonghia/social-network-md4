package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;

    @ManyToOne
    private Post post;
}
