package com.example.bibliotecaScolastica.service;

import java.util.List;

import com.example.bibliotecaScolastica.model.AggiungiLibroDTO;
import com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.model.ModificaLibroDTO;
import com.example.bibliotecaScolastica.model.PrestitoDettaglioDTO;
import com.example.bibliotecaScolastica.model.infoPrestito;

public interface LibriService {
	//API estrazione tutti i libri disponibili
	List<Libro> getAllLibri();
	
	//API concessione prestito
	void inizializzaPrestito(Long idLibro, Long idAlunno)throws Exception ;
	
	//API estrazione i libri di un utente
	List<PrestitoDettaglioDTO> getLibriInPrestitoPerUtente(Long idUtente);
	
	//API rimozione libro
	void deleteLibro(Long idLibro);
	
	//API aggiunta libro
	void addLibro(AggiungiLibroDTO aggiuniLibroDTO);
	
	//API modifica libro
	void modificaLibro (ModificaLibroDTO modificaLibroDTO, Long idLibro);
}
