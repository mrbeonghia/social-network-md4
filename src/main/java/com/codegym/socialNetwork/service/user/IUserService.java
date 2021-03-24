package com.codegym.socialNetwork.service.user;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IService<AppUser>, UserDetailsService {
    AppUser getUserByUsername(String username);
}
