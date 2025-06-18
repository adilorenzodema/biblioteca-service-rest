package com.example.bibliotecaScolastica.service;

import java.util.List;

import com.example.bibliotecaScolastica.model.AggiungiLibroDTO;
import com.example.bibliotecaScolastica.model.Libro;

public interface LibriService {
	//API estrazione tutti i libri disponibili
	List<Libro> getAllLibri();
	
	//API estrazione i libri di un utente
	void inizializzaPrestito(Long idLibro, Long idAlunno)throws Exception ;
	
	//API concessione prestito
	List<Libro> getLibriInPrestitoPerUtente(Long idUtente);
	
	//API rimozione libro
	void deleteLibro(Long idLibro);
	
	//API aggiunta libro
	void addLibro(AggiungiLibroDTO aggiuniLibroDTO);
	
}
