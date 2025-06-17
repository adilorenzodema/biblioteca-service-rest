package com.example.bibliotecaScolastica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro", schema = "schemabiblioteca")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idlibro")
	private Long idLibro;
	
	@Column(nullable=false, name="titolo")
	private String titolo;
	@Column(name="autore")
	private String autore;
	@Column(name="casaeditrice")
	private String casaEditrice;
	@Column(name="genere")
	private String genere;
	@Column(name="codiceiban")
	private String iban;
	
	@Column(nullable=false, name="disponibilita")
	private int disponibilita;
	
	@Column(nullable=false, name="datacreazione")
	private LocalDateTime dataCreazione;
	
	@Column(nullable=false, name="datamodifica")
	private LocalDateTime dataModifica;
	
	@Column(name="link")
	private String link;

	//Costruttore vuoto richiesto da JPA
    public Libro() {
    }
	
	//Costruttore
	public Libro(String titolo, String autore,String casaEditrice,String genere, String IBAN, int disponibilita,LocalDateTime dataCreazione,LocalDateTime dataModifica,String Link) {
		this.titolo=titolo;
		this.autore=autore;
		this.casaEditrice=casaEditrice;
		this.genere=genere;
		this.iban=IBAN;
		this.disponibilita=disponibilita;
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
		this.link=link;
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
	public String getLink() {return link;}
	public void setLink(String link) {
		this.link=link;
	}


}
