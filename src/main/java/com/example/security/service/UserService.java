package com.example.security.service;

import com.example.security.model.UserDetailsModel;
import com.example.security.repository.UserDetailsRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDetailsRepo userDetailsRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserDetailsRepo userDetailsRepo) {
        this.userDetailsRepo = userDetailsRepo;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public void addUser(UserDetailsModel req) {
        req.setPassword(bCryptPasswordEncoder.encode(req.getPassword()));
        userDetailsRepo.save(req);
    }
}
