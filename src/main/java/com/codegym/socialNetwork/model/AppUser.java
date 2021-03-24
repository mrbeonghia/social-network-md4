package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String firstName;

    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10,12})")
    private String phoneNumber;

    private String gender;

    @Column(columnDefinition = "TEXT")
    private String ImageUser;

    @ManyToOne
    private AppRole appRole;
}
