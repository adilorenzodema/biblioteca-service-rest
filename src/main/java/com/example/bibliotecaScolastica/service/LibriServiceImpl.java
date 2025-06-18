package com.example.bibliotecaScolastica.service;
import com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.repository.LibriRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class LibriServiceImpl implements LibriService {
	private final LibriRepository libriRepository;
	private Prestito prestito;
	private Utente utente;
	public LibriServiceImpl(LibriRepository libriRepository) {
		this.libriRepository=libriRepository;
	}
	@Override
	public List<Libro> getAllLibri() {
		return libriRepository.findAllNative();
	}
	@Override
	public List<Libro> getLibriInPrestitoPerUtente(Long idUtente) {
	    return libriRepository.findLibriInPrestitoByUtenteId(idUtente);
	}
	@Override
	public void inizializzaPrestito(Long idLibro, Long idAlunno) throws Exception {
	    Libro libro = libriRepository.findById(idLibro)
	            .orElseThrow(() -> new EntityNotFoundException("Libro non trovato"));

	    if (libro.getDisponibilita() <= 0) {
	        throw new IllegalStateException("Libro non disponibile");
	    }

	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime dataFine = now.plusDays(30);

	    libriRepository.concediPrestito(
	        idLibro,
	        idAlunno,
	        now,
	        dataFine,
	        now,
	        now,
	        null // data restituzione ancora nulla
	    );

	    // Decrementa disponibilità
	    libro.setDisponibilita(libro.getDisponibilita() - 1);
	    libriRepository.save(libro);
	}

	public Prestito getPrestito() {return prestito;}
		
	@Override
	public void deleteLibro(Long idLibro) {
	    try {
	        libriRepository.deleteLibro(idLibro);
	    } catch (Exception e) {
	        // Il DB solleva un'eccezione se il libro è in prestito (vincolo FK)
	        throw new IllegalStateException("Impossibile cancellare libro: si è verificato un errore.");
	    }
	}


}
