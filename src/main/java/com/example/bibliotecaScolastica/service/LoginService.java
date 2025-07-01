package com.example.bibliotecaScolastica.service;

import com.example.bibliotecaScolastica.model.UtenteDTO;

public interface LoginService {
	  UtenteDTO checkUser(String username, String password); 
}
