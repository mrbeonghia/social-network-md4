package com.codegym.socialNetwork.service.role;

import com.codegym.socialNetwork.model.AppRole;
import com.codegym.socialNetwork.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public AppRole findByName(String name) {
        return roleRepo.findByName(name);
    }

    @Override
    public Iterable<AppRole> findAll() {
        return null;
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(AppRole appRole) {

    }

    @Override
    public void remove(Long id) {

    }
}
