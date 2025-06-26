package com.example.bibliotecaScolastica.model;

import java.security.Timestamp;
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
	private Timestamp dataInizio;
	
	@Column(nullable=false,name="datafine")
	private Timestamp dataFine;
	
	@Column(nullable=false,name="datacreazione")
	private Timestamp dataCreazione;
	
	@Column(nullable=false,name="datamodifica")
	private Timestamp dataModifica;
	
	@Column(nullable=true,name="datarestituzione")
	private Timestamp dataRestituzione;
	
	//Costruttori
	public Prestito() {}
	public Prestito( Long idLibro, Long idUtente,Timestamp dataInzio, Timestamp dataFine, Timestamp dataCreazione, Timestamp dataModifica,Timestamp dataRestituzione) {
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
	
	public Timestamp getDataInzio(){return dataInizio;}
	public void setDataInzio(Timestamp dataInizio) {
		this.dataInizio=dataInizio;
	}
	
	public Timestamp getDataFine(){return dataFine;}
	public void setDataFine(Timestamp dataFine) {
		this.dataFine=dataFine;
	}
	
	public Timestamp getDataCreazione() {return dataCreazione;}
	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione=dataCreazione;
	}
	
	public Timestamp getDataModifica() {return dataModifica;}
	public void setDataModifica(Timestamp dataModifica) {
		this.dataModifica=dataModifica;
	}
	
	public Timestamp getDataRestituzione() {return dataRestituzione;}
	public void setDatarestituzione(Timestamp dataRestituzione) {
		this.dataRestituzione=dataRestituzione;
	}
}
