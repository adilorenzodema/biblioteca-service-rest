package com.example.bibliotecaScolastica.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
public class Ruolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRuolo;
	
	@Column(name="datacreazione")
	private LocalDateTime dataCreazione;
	
	@Column(name="datamodifica")
	private LocalDateTime dataModifica;
	
	@Column (name="ruolo")
	private String ruolo;
	
	//Costruttori
	public Ruolo() {}
	
	public Ruolo (LocalDateTime dataCreazione, LocalDateTime dataModifica, String ruolo) {
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
		this.ruolo=ruolo;
	}
	
	public Long getIdRuolo() {return idRuolo;}
	public void setIdRuolo(Long idRuolo) {
		this.idRuolo=idRuolo;
	}
	
	public LocalDateTime getDataCreazione() {return dataCreazione;}
	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione=dataCreazione;
	}
	
	public LocalDateTime getDataModifica() {return dataModifica;}
	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica=dataModifica;
	}
	public String getRuolo() {return ruolo;}
	public void setRuolo(String ruolo) {
		this.ruolo=ruolo;
	}
	
}
