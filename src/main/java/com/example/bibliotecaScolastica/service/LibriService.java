package com.example.bibliotecaScolastica.service;

import java.util.List;

import com.example.bibliotecaScolastica.model.Libro;

public interface LibriService {
	List<Libro> getAllLibri();
	
	void inizializzaPrestito(Long idLibro, Long idAlunno)throws Exception ;

}

public List<Libro> getLibriPerUtente(String username) {
    
}

