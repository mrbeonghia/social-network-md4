package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private AppUser CurrentUser;
    @OneToMany
    private List<AppUser> Friend;
    private Date createAt;
}
