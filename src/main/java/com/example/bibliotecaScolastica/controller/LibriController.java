package com.example.bibliotecaScolastica.controller;
import  com.example.bibliotecaScolastica.model.Libro;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libri")
public class LibriController {
	@GetMapping
	public List<Libro> getAllLibri(){
		return null;
	}

}
