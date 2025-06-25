package com.example.bibliotecaScolastica.service;

import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.repository.PrestitoRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Service
public class PrestitoServiceImpl implements PrestitoService {

    private final PrestitoRepository prestitoRepository;
    private final EntityManager entityManager;

    public PrestitoServiceImpl(PrestitoRepository prestitoRepository, EntityManager entityManager) {
        this.prestitoRepository = prestitoRepository;
        this.entityManager = entityManager;
    }

	    @Override
	    @Transactional
	    public String terminaPrestito(Long idPrestito) {
	    	Prestito prestito = entityManager.find(Prestito.class, idPrestito);
	        if (prestito == null || prestito.getDataRestituzione() != null) {
	            throw new IllegalArgumentException("Prestito non trovato o già restituito.");
	        }

	        prestitoRepository.aggiornaDataRestituzione(idPrestito);
	        prestitoRepository.incrementaDisponibilita(prestito.getIdLibro());

	        return prestitoRepository.getNomeCognomeUtente(prestito.getIdUtente());
	    }
}

