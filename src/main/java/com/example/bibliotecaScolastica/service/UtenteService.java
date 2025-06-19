package com.example.bibliotecaScolastica.service;

import java.util.List;

import com.example.bibliotecaScolastica.model.UtenteDTO;

public interface UtenteService {
	//API estrazione tutti gli utenti presenti
	List<UtenteDTO> getAllUtenti(String nomeRuolo);
}
