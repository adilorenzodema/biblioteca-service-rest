package com.example.bibliotecaScolastica.service;
import com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.repository.LibriRepository;
import com.example.bibliotecaScolastica.service.LibriService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibriServiceImpl implements LibriService {
	private final LibriRepository libriRepository;
	public LibriServiceImpl(LibriRepository libriRepository) {
		this.libriRepository=libriRepository;
	}
	@Override
	public List<Libro> getAllLibri() {
		return libriRepository.findAllNative();
	}

}
