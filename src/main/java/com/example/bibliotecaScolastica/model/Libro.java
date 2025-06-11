package com.example.bibliotecaScolastica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibro;
	
	@Column(nullable=false)
	private String titolo;
	@Column
	private String autore;
	@Column
	private String casaEditrice;
	@Column
	private String genere;
	@Column
	private String iban;
	
	@Column(nullable=false)
	private int disponibilita;
	
	@Column(nullable=false)
	private LocalDateTime dataCreazione;
	
	@Column(nullable=false)
	private LocalDateTime dataModifica;
	
	//Costruttore
	public Libro(String titolo, String autore,String casaEditrice,String genere, String IBAN, int disponibilita,LocalDateTime dataCreazione,LocalDateTime dataModifica) {
		this.titolo=titolo;
		this.autore=autore;
		this.casaEditrice=casaEditrice;
		this.genere=genere;
		this.iban=IBAN;
		this.disponibilita=disponibilita;
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
	}
	
	//Metodi getter e setter
	public Long getIdLibro() {return idLibro;}
	public void setIdLibro(Long idLibro) {
		this.idLibro=idLibro;
	}
	
	public String getTitolo() {return titolo;}
	public void setTitolo (String titolo) {
		this.titolo=titolo;
	}
	
	public String getAutore() {return autore;}
	public void setAutore (String autore) {
		this.autore=autore;
	}
	
	public String getCasaEditrice() {return casaEditrice;}
	public void setCasaEditricie(String casaEditrice) {
		this.casaEditrice=casaEditrice;
	}
	public String getGenere() {return genere;}
	public void setGenere(String genere) {
		this.genere=genere;
	}
	
	public String getIBAN() {return iban;}
	public void setCodiceIban(String iban){
		this.iban=iban;
	}
	
	public int getDisponibilita() { return disponibilita;}
	public void setDisponibilita (int disponibilita) {
		this.disponibilita=disponibilita;
	}
	
	public LocalDateTime getDataCreazione() {return dataCreazione;}
	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione=dataCreazione;
	}
	
	public LocalDateTime getDataModifica() {return dataModifica;}
	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica=dataModifica;
	}
	

}
