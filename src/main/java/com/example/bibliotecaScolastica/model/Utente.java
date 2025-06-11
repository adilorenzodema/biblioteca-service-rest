package com.example.bibliotecaScolastica_service;
import java.persistence.*;
@Entity
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlunno;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private String codiceFiscale;
	
	@Column(nullable=false)
	private String classe;
	
	@Column(nullable=false)
	private LocalDateTime dataCreazione;
	
	@Column(nullable=false)
	private LocalDateTime dataModifica;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private boolean active;
	
	@Column (nullabe=false)
	private int idRuolo;
	
	//Costruttore
	public Utente (Long idRuolo, String nome, String cognome, String codiceFiscale, String classe,LocalDateTime dataCreazione, LocalDateTime dataModifica,String username,String password,boolean active, int idRuolo) {
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
	
	public int getIdRuolo() {return idRuolo;}
	public void setIdRuolo() {
		this.idRuolo=idRuolo;
	}
	
}
