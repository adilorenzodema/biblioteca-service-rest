package com.example.bibliotecaScolastica.service;

import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.repository.LoginRepository;
@Service 
public class LoginServiceImpl implements LoginService{
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
            // Popola tutti i campi necessari nel DTO
            return new UtenteDTO(
                utente.getIdUtente(),
                utente.getNome(),
                utente.getCognome(),
                utente.getCodiceFiscale(),
                utente.getClasse(),
                utente.getDataCreazione(),
                utente.getDataModifica(),
                utente.getUsername(),
                utente.getPassword(),
                utente.getActive(),
                utente.getIdRuolo(),
                utente.getNomeRuolo() // Questo ora è popolato dalla query
            );
        } else {
            throw new IllegalArgumentException("Password errata");
        }
    }
}
