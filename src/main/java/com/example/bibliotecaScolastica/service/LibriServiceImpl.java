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
    public List<Libro> getLibriPerUtente(Long idUtente) {
        return libriRepository.findAllByUtenteId(idUtente);
	}
	@Override
	public void inizializzaPrestito(Long idLibro, Long idAlunno) throws Exception {
		Libro libro = libriRepository.findById(idLibro)
                .orElseThrow(() -> new EntityNotFoundException("Libro non trovato"));
		LocalDateTime dataOdierna=LocalDateTime.now();
		LocalDateTime dataScadenza=dataOdierna.plusDays(30);
		LocalDateTime dataCreazione=LocalDateTime.now();
		LocalDateTime dataModifica=LocalDateTime.now();
		//Controlla disponibilità
		if(!(libro.getDisponibilita()==0)) {
			throw new IllegalStateException("Libro non disponibile");
		}
		libriRepository.concediPrestito(libro.getIdLibro(),idAlunno,dataOdierna,dataScadenza,dataCreazione,null);
		int disponibilitaLibro=libro.getDisponibilita();
		libro.setDisponibilita(disponibilitaLibro);
	}
	public Prestito getPrestito() {return prestito;}
	
	

}
