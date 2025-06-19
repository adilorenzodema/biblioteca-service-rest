package com.example.bibliotecaScolastica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
}
