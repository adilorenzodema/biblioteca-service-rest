package com.example.bibliotecaScolastica.model;

import java.sql.Timestamp;


public class UtenteDTO {
	private Integer idUtente;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String classe;
	private Timestamp dataCreazione;
	private Timestamp dataModifica;
	private String username;
	private String password;
	private Boolean active;
	private int idRuolo;
	private String nomeRuolo;
	
	public UtenteDTO() {
    }
	public UtenteDTO (Integer idUtente, String nome, String cognome, String codiceFiscale, String classe,Timestamp dataCreazione, Timestamp dataModifica,String username,String password,Boolean active,int idRuolo,String nomeRuolo) {
		this.idUtente=idUtente;
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
		this.nomeRuolo=nomeRuolo;
	}
	public UtenteDTO(String username, String nomeRuolo) {
        this.username = username;
        this.nomeRuolo = nomeRuolo;
    }
		//metodi getter e setter
		public Integer getIdUtente() {return idUtente;}
		public void setIdUtente(Integer idUtente) {
			this.idUtente=idUtente;
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
		
		public Timestamp getDataCreazione() {return dataCreazione;}
		public void setDataCreazione(Timestamp dataCreazione) {
			this.dataCreazione=dataCreazione;
		}
		
		public Timestamp getDataModifica() {return dataModifica;}
		public void setDataModifica(Timestamp dataModifica) {
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
		
		public String getNomeRuolo() {return nomeRuolo;}
		public void setNomeRuolo(String nomeRuolo) {
			this.nomeRuolo=nomeRuolo;
		}
}
