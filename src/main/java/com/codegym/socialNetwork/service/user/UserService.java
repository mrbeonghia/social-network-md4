package com.codegym.socialNetwork.service.user;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Iterable<AppUser> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(AppUser user) {
        userRepo.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = this.getUserByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getAppRole());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );

        return userDetails;
    }


    @Override
    public AppUser getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public AppUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        AppUser user = userRepo.findByUsername(userName);
        return user;
    }
}
