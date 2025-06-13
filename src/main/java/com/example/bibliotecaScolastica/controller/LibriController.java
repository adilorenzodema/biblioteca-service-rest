package com.example.bibliotecaScolastica.controller;
import  com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.service.LibriService;
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
	
    
    //TODO api getMyLibri (input username) restutisce list<Libro> 
    
}
