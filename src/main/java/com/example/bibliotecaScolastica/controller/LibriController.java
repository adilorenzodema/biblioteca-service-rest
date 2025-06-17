package com.example.bibliotecaScolastica.controller;
import  com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.User;
import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.model.infoPrestito;
import com.example.bibliotecaScolastica.service.LibriService;
import com.example.bibliotecaScolastica.service.LoginService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libri")
public class LibriController {
	public final LibriService libriService;

	public LibriController(LibriService libriService) {
        this.libriService = libriService;
    }

    @GetMapping("/getAllLibri")
    public List<Libro> getTuttiILibri() {
        return libriService.getAllLibri();
    }
	
    @GetMapping("/getMyLibri")
    public List<Libro> getLibriPerUtente(@RequestParam String username) {
        return libriService.getLibriPerUtente(username);
    }
        
    
    @PostMapping("/concedi")
    public ResponseEntity<?> concederePrestito(@RequestBody infoPrestito infoPrestito) throws Exception{
    	try {
    		libriService.inizializzaPrestito(infoPrestito.getIdLibro(),infoPrestito.getIdUtente());
    		return ResponseEntity.status(HttpStatus.CREATED).body("Prestito avvenuto con successo");
    	}catch(EntityNotFoundException e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore del server");
        }
    	
    }

}
