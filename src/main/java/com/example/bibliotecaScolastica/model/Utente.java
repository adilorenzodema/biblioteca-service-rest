package com.example.bibliotecaScolastica.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idalunno")
	private Long idAlunno;
	
	@Column(nullable=false,name="nome")
	private String nome;
	
	@Column(nullable=false,name="cognome")
	private String cognome;
	
	@Column(nullable=false,name="codicefiscale")
	private String codiceFiscale;
	
	@Column(nullable=false,name="classe")
	private String classe;
	
	@Column(nullable=false,name="datacreazione")
	private LocalDateTime dataCreazione;
	
	@Column(nullable=false,name="datamodifica")
	private LocalDateTime dataModifica;
	
	@Column(nullable=false,name="username")
	private String username;
	
	@Column(nullable=false,name="password")
	private String password;
	
	@Column(nullable=false,name="active")
	private boolean active;
	
	@Column (nullable=false,name="idruolo")
	private Integer idRuolo;
	
	public Utente() { }
	
	public Utente (int idRuolo, String nome, String cognome, String codiceFiscale, String classe,LocalDateTime dataCreazione, LocalDateTime dataModifica,String username,String password,boolean active) {
		this.idRuolo=idRuolo;
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.classe=classe;
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
	}
	
	//metodi getter e setter
	public Long getIdUtente() {return idAlunno;}
	public void setIdUtente(Long idAlunno) {
		this.idAlunno=idAlunno;
	}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	
	public String getCodiceFiscale() {return codiceFiscale;}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale=codiceFiscale;
	}
	
	public String getClasse() {return classe;}
	public void setClasse(String classe) {
		this.classe=classe;
	}
	
	public LocalDateTime getDataCreazione() {return dataCreazione;}
	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione=dataCreazione;
	}
	
	public LocalDateTime getDataModifica() {return dataModifica;}
	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica=dataModifica;
	}
	
	public String getUsername() {return username;}
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {
		this.password=password;
	}
	
	public boolean getActive() {return active;}
	public void setActive(boolean active) {
		this.active=active;
	}
	
	public Integer getIdRuolo() {return idRuolo;}
	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo=idRuolo;
	}
}
