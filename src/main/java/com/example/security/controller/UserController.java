package com.example.security.controller;

import com.example.security.model.UserDetailsModel;
import com.example.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> register(@Valid @RequestBody UserDetailsModel req, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("bindingResult-->> " + bindingResult.toString());
            return ResponseEntity.badRequest().body(Map.of("message", bindingResult.getFieldError().getDefaultMessage()));
        }

        System.out.println("req-->> " + req.toString());
        userService.addUser(req);

        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

}
