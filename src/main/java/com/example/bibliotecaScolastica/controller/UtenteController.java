package com.example.bibliotecaScolastica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.example.bibliotecaScolastica.model.UtenteDTO;

import com.example.bibliotecaScolastica.service.UtenteService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/utente")
public class UtenteController {
	public final UtenteService utenteService;

	public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }
	
	//API estrazione tutti gli utenti presenti
	@GetMapping("/getAllUtenti/{nomeRuolo}")
	public List<UtenteDTO> getTuttiUtenti(@PathVariable String nomeRuolo) {
	    return utenteService.getAllUtenti(nomeRuolo);
	}

    
  //API rimozione utente
  @DeleteMapping("/{idUtente}")
  public ResponseEntity<?> deleteUtente(@PathVariable Long idUtente) {
      try {
          utenteService.deleteUtente(idUtente);
          return ResponseEntity.ok("Utente cancellato con successo");
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                               .body("Errore durante la cancellazione: " + e.getMessage());
      }
  }
  
	//API aggiunta utente
	  @PostMapping("/aggiungiUtente")
	  public ResponseEntity<?> aggiungereUtente(@RequestBody UtenteDTO utenteDTO) throws Exception{
	  	try {
	  		utenteService.addUtente(utenteDTO);
	  		return ResponseEntity.status(HttpStatus.CREATED).body("Utente aggiunto con successo");
	  	}catch(EntityNotFoundException e) {
	  		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	  	}catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore del server");
	      }
	  }
	  
	// API modificaUtente
	  @PostMapping("/modificaUtente")
	  public ResponseEntity<?> modificaUtente(@RequestBody UtenteDTO utenteDTO) {
	      try {
	          utenteService.modificaUtente(utenteDTO);
	          return ResponseEntity.ok("Utente modificato con successo");
	      } catch (EntityNotFoundException e) {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utente non trovato");
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                               .body("Errore durante la modifica: " + e.getMessage());
	      }
	  }
	  
}
