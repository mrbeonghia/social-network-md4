package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createAt;
    @OneToOne
    private StatusRequest statusRequest;
    @ManyToOne
    private AppUser from;
    @ManyToOne
    private AppUser to;
}
