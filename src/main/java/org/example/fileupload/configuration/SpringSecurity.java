//package com.example.uberprojectauthservice.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringSecurity {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf(csrf-> csrf.disable()).authorizeHttpRequests(
//                        (requests) -> requests
//                                .requestMatchers("/uploadFile").permitAll())
////                                .requestMatchers("/api/v1/auth/signin").permitAll())
//                .build();
//    }
//
//
//}