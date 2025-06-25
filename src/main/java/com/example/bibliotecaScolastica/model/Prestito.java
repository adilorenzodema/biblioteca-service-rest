package com.example.bibliotecaScolastica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "prestito", schema = "schemabiblioteca")
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idprestito")
	private Long idPrestito;
	
	@Column(nullable=false, name="idlibro")
	private Long idLibro;
	
	@Column(nullable=false,name="idutente")
	private Long idUtente;
	
	@Column(nullable=false,name="datainizio")
	private LocalDateTime dataInizio;
	
	@Column(nullable=false,name="datafine")
	private LocalDateTime dataFine;
	
	@Column(nullable=false,name="datacreazione")
	private LocalDateTime dataCreazione;
	
	@Column(nullable=false,name="datamodifica")
	private LocalDateTime dataModifica;
	
	@Column(nullable=true,name="datarestituzione")
	private LocalDateTime dataRestituzione;
	
	//Costruttori
	public Prestito() {}
	public Prestito( Long idLibro, Long idUtente,LocalDateTime dataInzio, LocalDateTime dataFine, LocalDateTime dataCreazione, LocalDateTime dataModifica,LocalDateTime dataRestituzione) {
		this.idLibro=idLibro;
		this.idUtente=idUtente;
		this.dataInizio=dataInzio;
		this.dataFine=dataFine;
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
		this.dataRestituzione=dataRestituzione;
	}
	//Metodi getter e setter
	public Long getIdPrestito() {return idPrestito;}
	public void setIdPrestito(Long idPrestito) {
		this.idPrestito=idPrestito;
	}
	
	public Long getIdLibro() {return idLibro;}
	public void setIdLibro(Long idLibro) {
		this.idLibro=idLibro;
	}
	
	public Long getIdUtente() {return idUtente;}
	public void setIdUtente(Long idUtente) {
		this.idUtente=idUtente;
	}
	
	public LocalDateTime getDataInzio(){return dataInizio;}
	public void setDataInzio(LocalDateTime dataInizio) {
		this.dataInizio=dataInizio;
	}
	
	public LocalDateTime getDataFine(){return dataFine;}
	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine=dataFine;
	}
	
	public LocalDateTime getDataCreazione() {return dataCreazione;}
	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione=dataCreazione;
	}
	
	public LocalDateTime getDataModifica() {return dataModifica;}
	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica=dataModifica;
	}
	
	public LocalDateTime getDataRestituzione() {return dataRestituzione;}
	public void setDatarestituzione(LocalDateTime dataRestituzione) {
		this.dataRestituzione=dataRestituzione;
	}
}
