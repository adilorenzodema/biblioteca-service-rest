package com.example.bibliotecaScolastica.service;

import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.repository.LoginRepository;

@Service 
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;
    
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    @Override
    public UtenteDTO checkUser(String username, String password) {
        UtenteDTO utente = this.loginRepository.checkUtente(username);
        if(utente == null) {
            throw new IllegalArgumentException("Utente non trovato");
        }
        
        if (utente.getPassword().equals(password)) {
            return utente; // Return the DTO directly
        } else {
            throw new IllegalArgumentException("Password errata");
        }
    }
}