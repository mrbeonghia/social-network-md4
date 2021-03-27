package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
