package com.example.bibliotecaScolastica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Prestito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestito;
	
	@Column(nullable=false)
	private Long idLibro;
	
	@Column(nullable=false)
	private Long idAlunno;
	
	@Column(nullable=false)
	private LocalDateTime dataInizio;
	
	@Column(nullable=false)
	private LocalDateTime dataFine;
	
	@Column(nullable=false)
	private LocalDateTime dataCreazione;
	
	@Column(nullable=false)
	private LocalDateTime dataModifica;
	
	public Prestito(Long idPrestito, Long idLibro, Long idAlunno,LocalDateTime dataInzio, LocalDateTime dataFine, LocalDateTime dataCreazione, LocalDateTime dataModifica) {
		this.idPrestito=idPrestito;
		this.idLibro=idLibro;
		this.idAlunno=idAlunno;
		this.dataInizio=dataInzio;
		this.dataFine=dataFine;
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
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
	
	public Long getIdUtente() {return idAlunno;}
	public void setIdUtente(Long idAlunno) {
		this.idAlunno=idAlunno;
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
}
