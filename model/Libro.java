package com.example.bibliotecaScolastica_service;
import java.persistence.*;
@Entity
public class Libro {
	//attributi
	
	//caratteristiche
	private final String TITOLO;
	private final String AUTORE;
	private final String CASAEDITRICE;
	private final String GENERE;
	private final String IBAN;
	
	//stato
	private int disponibilita;
	private localDateTime dataCreazione;

}
