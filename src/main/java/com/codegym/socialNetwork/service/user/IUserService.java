package com.codegym.socialNetwork.service.user;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IService<AppUser>, UserDetailsService {
    AppUser getUserByUsername(String username);
}
