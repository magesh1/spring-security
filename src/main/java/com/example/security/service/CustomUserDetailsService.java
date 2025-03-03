package com.example.security.service;

import com.example.security.model.UserDetailsModel;
import com.example.security.model.UserPrincipal;
import com.example.security.repository.UserDetailsRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDetailsRepo repo;

    public CustomUserDetailsService(UserDetailsRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsModel users = repo.findByUserName(username);

        if (users == null) {
            String val = "user " + username + " not found";
            throw new UsernameNotFoundException(val);
        }

        return new UserPrincipal(users);
    }
}
