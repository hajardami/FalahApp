package com.backFalahApp.BackFalahApp.service;

import com.backFalahApp.BackFalahApp.model.AppUser;
import com.backFalahApp.BackFalahApp.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserPrincipalDetailService implements UserDetailsService {
    private UserService userService;

    public UserPrincipalDetailService( UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        AppUser user = null;
        try {
            user = userService.getUserWithEmail(email);
            user.setEnabled(true);
        } catch (Throwable e) {}
        if (user == null) throw new UsernameNotFoundException(email);
        return new UserPrincipal(user);
    }
}
