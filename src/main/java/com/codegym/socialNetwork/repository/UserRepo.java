package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
