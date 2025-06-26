package com.example.bibliotecaScolastica.service;

import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.model.infoPrestito;
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
	
	//API estrazione tutti gli prestiti presenti
	@Override
	public List<infoPrestito> getAllPrestiti(Long idLibro) {
		List<Object[]> results = prestitoRepository.findAllPrestiti(idLibro);
		List<infoPrestito> prestiti = new ArrayList<>();

		for (Object[] row : results) {
			Long idUtente = ((Number) row[0]).longValue();
			Long idLibroResult = ((Number) row[1]).longValue();
			String nomeCognome = (String) row[2];

			Timestamp dataFine = null;
			if (row[3] instanceof Timestamp ts) {
				dataFine = ts;
			} else if (row[3] instanceof Date date) {
				dataFine = new Timestamp(date.getTime());
			}

			prestiti.add(new infoPrestito(idUtente, idLibroResult, nomeCognome, dataFine,null));
		}
		return prestiti;
	}
	
	//API estrazione tutti gli prestiti non attivi
	@Override
	public List<infoPrestito> getAllPrestitiConclusi(Long idLibro) {
		List<Object[]> results = prestitoRepository.findAllPrestitiConclusi(idLibro);
		List<infoPrestito> prestiti = new ArrayList<>();
			
		for (Object[] row : results) {
			Long idUtente = ((Number) row[0]).longValue();
			Long idLibroResult = ((Number) row[1]).longValue();
			String nomeCognome = (String) row[2];

			Timestamp dataFine = null;
	        Timestamp dataRestituzione = null;

			if (row[3] instanceof Timestamp ts) {
				dataFine = ts;
			} else if (row[3] instanceof Date date) {
				dataFine = new Timestamp(date.getTime());
			}
			
			if (row[4] instanceof Timestamp ts) {
	            dataRestituzione = ts;
	        } else if (row[4] instanceof Date date) {
	            dataRestituzione = new Timestamp(date.getTime());
	        }
	        prestiti.add(new infoPrestito(idUtente, idLibroResult, nomeCognome, dataFine, dataRestituzione));
		}
		return prestiti;
	}

	    
}

