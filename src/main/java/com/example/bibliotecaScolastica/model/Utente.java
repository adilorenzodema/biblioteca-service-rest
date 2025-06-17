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
	@Column(name="idutente")
	private Long idUtente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="codicefiscale")
	private String codiceFiscale;
	
	@Column(name="classe")
	private String classe;
	
	@Column(name="datacreazione")
	private LocalDateTime dataCreazione;
	
	@Column(name="datamodifica")
	private LocalDateTime dataModifica;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private Boolean active;
	
	@Column (name="idruolo")
	private int idRuolo;
	
	public Utente() { }
	
	public Utente (Long idAlunno, String nome, String cognome, String codiceFiscale, String classe,LocalDateTime dataCreazione, LocalDateTime dataModifica,String username,String password,Boolean active,int idRuolo) {
		this.idAlunno=idAlunno;
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.classe=classe;
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
		this.username=username;
		this.password=password;
		this.active=active;
		this.idRuolo=idRuolo;
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
	
	public Boolean getActive() {return active;}
	public void setActive(Boolean active) {
		this.active=active;
	}
	
	public int getIdRuolo() {return idRuolo;}
	public void setIdRuolo(int idRuolo) {
		this.idRuolo=idRuolo;
	}
}
