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

    // Bean di esempio per credenziali hardcoded (solo per testing)
    @Bean
    public UserCredentials defaultUserCredentials() {
        return new UserCredentials("admin", encodePassword("password123"));
    }

    // Metodo di utilità per codificare una password
    public String encodePassword(String rawPassword) {
        return passwordEncoder().encode(rawPassword);
    }

    // Classe interna per memorizzare credenziali (puoi sostituirla con un Database)
    public static class UserCredentials {
        private String username;
        private String encodedPassword;

        public UserCredentials(String username, String encodedPassword) {
            this.username = username;
            this.encodedPassword = encodedPassword;
        }

        // Getter
        public String getUsername() { return username; }
        public String getEncodedPassword() { return encodedPassword; }
    }
}
