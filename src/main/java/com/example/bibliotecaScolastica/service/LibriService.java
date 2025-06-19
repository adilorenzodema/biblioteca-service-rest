package com.example.bibliotecaScolastica.service;

import java.util.List;

import com.example.bibliotecaScolastica.model.AggiungiLibroDTO;
import com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.model.UtenteDTO;

public interface LibriService {
	//API estrazione tutti i libri disponibili
	List<Libro> getAllLibri();
	
	//API concessione prestito
	void inizializzaPrestito(Long idLibro, Long idAlunno)throws Exception ;
	
	//API estrazione i libri di un utente
	List<Libro> getLibriInPrestitoPerUtente(Long idUtente);
	
	//API rimozione libro
	void deleteLibro(Long idLibro);
	
	//API aggiunta libro
	void addLibro(AggiungiLibroDTO aggiuniLibroDTO);
	
	//API estrazione tutti gli utenti presenti
	List<UtenteDTO> getAllUtenti(String nomeRuolo);
}
