package com.example.bibliotecaScolastica.service;

import java.util.List;

import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.infoPrestito;

public interface PrestitoService {
	String terminaPrestito(Long idPrestito);
	
	List <infoPrestito>getAllPrestiti(Long idLibro);
	
	List <infoPrestito>getAllPrestitiConclusi(Long idLibro);

}
