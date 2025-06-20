package com.example.bibliotecaScolastica.controller;
import com.example.bibliotecaScolastica.model.AggiungiLibroDTO;
import  com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.model.infoPrestito;
import com.example.bibliotecaScolastica.service.LibriService;

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
	
	//API estrazione tutti i libri disponibili
    @GetMapping("/getAllLibri")
    public List<Libro> getTuttiILibri() {
        return libriService.getAllLibri();
    }
	
  //API estrazione i libri di un utente
    @GetMapping("/getMyLibri")
    public List<Libro> getLibriInPrestitoPerUtente(@RequestParam Long idUtente) {
        return libriService.getLibriInPrestitoPerUtente(idUtente);
    }
        
    //API concessione prestito
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
    
    //API rimozione libro
    @DeleteMapping("/{idLibro}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long idLibro) {
        try {
            libriService.deleteLibro(idLibro);
            return ResponseEntity.ok("Libro cancellato con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Errore durante la cancellazione: " + e.getMessage());
        }
    }
    
    //API aggiunta libro
    @PostMapping("/aggiungi")
    public ResponseEntity<?> aggiungereLibro(@RequestBody AggiungiLibroDTO aggiungiLibroDTO) throws Exception{
    	try {
    		libriService.addLibro(aggiungiLibroDTO);
    		return ResponseEntity.status(HttpStatus.CREATED).body("Libro aggiunto con successo");
    	}catch(EntityNotFoundException e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    

    
}
