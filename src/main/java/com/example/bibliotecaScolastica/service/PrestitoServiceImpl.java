package com.example.bibliotecaScolastica.service;

import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.model.infoPrestito;
import com.example.bibliotecaScolastica.repository.PrestitoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Service
public class PrestitoServiceImpl implements PrestitoService {

	@Autowired
    private PrestitoRepository prestitoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public PrestitoServiceImpl(PrestitoRepository prestitoRepository, EntityManager entityManager) {
        this.prestitoRepository = prestitoRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public String terminaPrestito(Long idPrestito) {
        System.out.println("terminaPrestito chiamato con idPrestito = " + idPrestito);
        
        Prestito prestito = entityManager.find(Prestito.class, idPrestito);
        if (prestito == null) {
            System.out.println("Prestito non trovato per id: " + idPrestito);
            throw new IllegalArgumentException("Prestito non trovato.");
        }
        
        if (prestito.getDataRestituzione() != null) {
            System.out.println("Prestito già restituito per id: " + idPrestito);
            throw new IllegalArgumentException("Prestito già restituito.");
        }
        
        prestitoRepository.aggiornaDataRestituzione(idPrestito);
        prestitoRepository.incrementaDisponibilita(prestito.getIdLibro());
        
        String nomeCognome = prestitoRepository.getNomeCognomeUtente(prestito.getIdUtente());
        System.out.println("Prestito terminato per utente: " + nomeCognome);
        return nomeCognome;
    }

	
	//API estrazione tutti gli prestiti presenti
	@Override
	public List<infoPrestito> getAllPrestiti(Long idLibro) {
		List<Object[]> results = prestitoRepository.findAllPrestiti(idLibro);
		List<infoPrestito> prestiti = new ArrayList<>();

		for (Object[] row : results) {
	        Long idPrestito = ((Number) row[0]).longValue();
			Long idUtente = ((Number) row[1]).longValue();
			Long idLibroResult = ((Number) row[2]).longValue();
			String nomeCognome = (String) row[3];

			Timestamp dataFine = null;
			if (row[4] instanceof Timestamp ts) {
				dataFine = ts;
			} else if (row[4] instanceof Date date) {
				dataFine = new Timestamp(date.getTime());
			}
			String titoloLibro = (String) row[5];
			prestiti.add(new infoPrestito(idPrestito,idUtente, idLibroResult, nomeCognome, dataFine,null,titoloLibro));
		}
		return prestiti;
	}
	
	//API estrazione tutti gli prestiti non attivi
	@Override
	public List<infoPrestito> getAllPrestitiConclusi(Long idLibro) {
	    List<Object[]> results = prestitoRepository.findAllPrestitiConclusi(idLibro);
	    List<infoPrestito> prestiti = new ArrayList<>();

	    for (Object[] row : results) {
	        Long idPrestito = ((Number) row[0]).longValue();
	        Long idUtente = ((Number) row[1]).longValue();
	        Long idLibroResult = ((Number) row[2]).longValue();
	        String nomeCognome = (String) row[3];

	        Timestamp dataFine = null;
	        Timestamp dataRestituzione = null;

	        if (row[4] instanceof Timestamp ts) {
	            dataFine = ts;
	        } else if (row[4] instanceof Date date) {
	            dataFine = new Timestamp(date.getTime());
	        }

	        if (row[5] instanceof Timestamp ts) {
	            dataRestituzione = ts;
	        } else if (row[5] instanceof Date date) {
	            dataRestituzione = new Timestamp(date.getTime());
	        }

	        String titoloLibro = (String) row[6];

	        prestiti.add(new infoPrestito(idPrestito, idUtente, idLibroResult, nomeCognome, dataFine, dataRestituzione, titoloLibro));
	    }
	    return prestiti;
	}



	    
}

