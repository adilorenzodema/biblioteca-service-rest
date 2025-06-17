package com.example.bibliotecaScolastica.service;

import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.repository.LoginRepository;
@Service 
public class LoginServiceImpl implements LoginService{
	private final LoginRepository loginRepository;
	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository=loginRepository;
	}
	
	@Override
	public Utente checkUser(String username, String password) {
	    Utente utente = this.loginRepository.checkUtente(username);
	    if(utente == null) {
	        throw new IllegalArgumentException("Credenziali errate");
	    }
	    
	    if (utente.getPassword().equals(password)) {
	        return utente;
	    } else {
	        throw new IllegalArgumentException("Password errata");
	    }
	}
}
