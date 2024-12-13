package com.projecmanagement.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and()

                .csrf().disable() // Consider enabling and configuring CSRF for browser-based clients
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/project/**").permitAll() // Public access

                        .anyRequest().authenticated() // All other requests need authentication
                );

        return httpSecurity.build();
    }
}
