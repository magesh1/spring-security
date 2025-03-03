package com.example.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private final UserDetailsModel userDetailsModel;

    public UserPrincipal(UserDetailsModel userDetailsModel) {
        this.userDetailsModel = userDetailsModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+userDetailsModel.getRole())); // since we are not using role
    }

    @Override
    public String getPassword() {
        return userDetailsModel.getPassword(); // get from db
    }

    @Override
    public String getUsername() {
        return userDetailsModel.getUserName(); // get from db
    }
}
