package com.example.security.controller;

import com.example.security.model.UserDetailsModel;
import com.example.security.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void register(@RequestBody UserDetailsModel req) {
        System.out.println("req-->> "+req.toString());
        userService.addUser(req);
    }

}
