package com.example.bibliotecaScolastica.service;

import java.util.List;

import com.example.bibliotecaScolastica.model.Libro;

public interface LibriService {
	List<Libro> getAllLibri();

}

public List<Libro> getLibriPerUtente(String username) {
    // Logica per recuperare i libri associati a un utente
    // Può essere da un repository o da una lista mock
    return libroRepository.findByUsername(username); // esempio con repository
}

