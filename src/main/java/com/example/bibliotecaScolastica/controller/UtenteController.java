package com.example.bibliotecaScolastica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.service.LibriService;
import com.example.bibliotecaScolastica.service.UtenteService;

@RestController
@RequestMapping("/api/utente")
public class UtenteController {
	public final UtenteService utenteService;

	public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }
	
	//API estrazione tutti gli utenti presenti
    @GetMapping("/getAllUtenti")
    public List<UtenteDTO> getTuttiUtenti(@RequestParam(required=false)String nomeRuolo) {
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
}
