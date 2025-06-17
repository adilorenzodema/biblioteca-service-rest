package com.example.bibliotecaScolastica.service;

import com.example.bibliotecaScolastica.model.Utente;

public interface LoginService {
	  Utente checkUser(String username, String password); 
}
