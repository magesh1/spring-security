package com.example.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;


    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity req) throws Exception {
        // 1. csrf disable
        req.csrf(customizer -> customizer.disable());
        // 2. same site strict will block cookie while routing through 3rd party
        // configured in the app.property

        req.authorizeHttpRequests(reqest -> reqest
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated() // this line will tell all the request should be authenticated
        );
        // it will used to show login page without this we cant access site
//        req.formLogin(Customizer.withDefaults()); // used for browser
        req.httpBasic(Customizer.withDefaults()); // used for postman

        // change session to stateless which prevent session hijack attack
        // will generate differen id when refresh
        req.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return req.build();
    }

    // used for db
    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // it will not check encoded password
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }


    // used for hard-coded
//    // this class will verify all the user creds
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("ganesh")
//                .password("123")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("bharath")
//                .password("234")
//                .roles("USER")
//                .build();
//
//        UserDetails user3 = User
//                .withDefaultPasswordEncoder()
//                .username("santhosh")
//                .password("santhosh")
//                .roles("CUS")
//                .build();
//        // mehtod -1
////        return new InMemoryUserDetailsManager(user1, user2, user3);
//        // method -2
//        List<UserDetails> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        return new InMemoryUserDetailsManager(users);
//    }

}
