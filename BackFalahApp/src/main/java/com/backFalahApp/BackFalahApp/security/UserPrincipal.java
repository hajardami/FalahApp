package com.backFalahApp.BackFalahApp.security;


import com.backFalahApp.BackFalahApp.enumerations.AppUserRole;
import com.backFalahApp.BackFalahApp.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private AppUser user;

    public UserPrincipal(AppUser user) {this.user = user;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name().toUpperCase()));
        return  grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isActive();

    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isActive();

    }

    @Override
    public boolean isEnabled() {
        return user.isActive();

    }


}
