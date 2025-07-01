package com.example.bibliotecaScolastica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.model.infoPrestito;
import com.example.bibliotecaScolastica.service.PrestitoService;

@RestController
@RequestMapping("/api/prestiti")
public class PrestitoController {

    private final PrestitoService prestitoService;

    public PrestitoController(PrestitoService prestitoService) {
        this.prestitoService = prestitoService;
    }

    @PutMapping("/terminaPrestito/{idPrestito}")
    public ResponseEntity<String> terminaPrestito(@PathVariable Long idPrestito) {
        try {
            String nomeCognome = prestitoService.terminaPrestito(idPrestito);
            return ResponseEntity.ok("Prestito terminato per l'alunno: " + nomeCognome);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    //API estrazione tutti i prestiti presenti
    @GetMapping({"/getAllPrestito", "/getAllPrestito/{idLibro}"})
    public List<infoPrestito> getTuttiPrestiti(@PathVariable(required = false) Long idLibro) {
        return prestitoService.getAllPrestiti(idLibro);
    }
    
    //API estrazione tutti i prestiti conclusi
    @GetMapping({"/getAllPrestitiConclusi", "/getAllPrestitiConclusi/{idLibro}"})
    public List<infoPrestito> getTuttiPrestitiConclusi(@PathVariable(required = false) Long idLibro) {
        return prestitoService.getAllPrestitiConclusi(idLibro);
    }

}