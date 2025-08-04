package com.suyos.ranti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .csrf(csrf -> csrf.disable()) // Optional: disable CSRF for non-browser testing
            .formLogin(form -> form.disable()) // Optional: disable form login
            .httpBasic(basic -> basic.disable()); // Optional: disable HTTP basic auth

        return http.build();
    }
}
