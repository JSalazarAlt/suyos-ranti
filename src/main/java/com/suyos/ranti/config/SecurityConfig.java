package com.suyos.ranti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the Ranti application.
 * Configures Spring Security settings including authentication and authorization.
 * 
 * @author Suyos Team
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class SecurityConfig {

    /**
     * Configures the security filter chain with permissive settings.
     * Currently allows all requests without authentication for development.
     * 
     * @param http HttpSecurity configuration object
     * @return configured SecurityFilterChain
     * @throws Exception if configuration fails
     * @since 1.0
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .csrf(csrf -> csrf.disable()) // Disable CSRF for development
            .formLogin(form -> form.disable()) // Disable form login
            .httpBasic(basic -> basic.disable()); // Disable HTTP basic auth

        return http.build();
    }
}
