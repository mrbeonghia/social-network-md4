package com.codegym.socialNetwork.security;


import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AppUser byUsername = userRepo.findByUsername(s);
        if (byUsername == null) {
            throw new UsernameNotFoundException("User with does not exists");
        }
        return new SpringUser(byUsername);
    }
}
