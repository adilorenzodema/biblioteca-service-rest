package com.example.bibliotecaScolastica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.repository.LibriRepository;
import com.example.bibliotecaScolastica.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService{	
	private final UtenteRepository utenteRepository;

    public UtenteServiceImpl(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }
	//API estrazione tutti gli utenti presenti
	@Override
	public List<UtenteDTO> getAllUtenti(String nomeRuolo) {
		return utenteRepository.findAllUtenti(nomeRuolo);
	}
}
