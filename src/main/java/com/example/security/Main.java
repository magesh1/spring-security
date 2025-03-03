package com.example.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "ganesh";
        String encodedPassword = encoder.encode(password);
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
