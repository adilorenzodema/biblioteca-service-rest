package com.example.bibliotecaScolastica.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoginConfiguration {

    // Bean per codificare/verificare le password (usa BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Metodo di utilità per codificare una password
    public String encodePassword(String rawPassword) {
        return passwordEncoder().encode(rawPassword);
    }
}
