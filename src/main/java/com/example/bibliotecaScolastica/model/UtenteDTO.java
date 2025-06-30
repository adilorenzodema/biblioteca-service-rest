package com.example.bibliotecaScolastica.model;

import java.sql.Timestamp;


public class UtenteDTO {
	 private Integer idUtente; // Changed to Long
	    private String nome;
	    private String cognome;
	    private String codiceFiscale;
	    private String classe;
	    private String email; // Moved up
	    private Integer codiceVerifica; // Changed to Integer
	    private Timestamp dataCreazione;
	    private Timestamp dataModifica;
	    private String username;
	    private String password;
	    private Boolean active;
	    private Integer idRuolo; // Changed to Integer
	    private String nomeRuolo;
	
	public UtenteDTO() {
    }
	public UtenteDTO(
	        Integer idUtente, 
	        String nome, 
	        String cognome, 
	        String codiceFiscale, 
	        String classe,
	        Timestamp dataCreazione,
	        Timestamp dataModifica,
	        String username,
	        String password,
	        Boolean active,
	        Integer idRuolo,
	        String email,
	        Integer codiceVerifica,
	        String nomeRuolo
	    ) {
	        this.idUtente = idUtente;
	        this.nome = nome;
	        this.cognome = cognome;
	        this.codiceFiscale = codiceFiscale;
	        this.classe = classe;
	        this.dataCreazione = dataCreazione;
	        this.dataModifica = dataModifica;
	        this.username = username;
	        this.password = password;
	        this.active = active;
	        this.idRuolo = idRuolo;
	        this.email = email;
	        this.codiceVerifica = codiceVerifica;
	        this.nomeRuolo = nomeRuolo;
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
		
		public String getEmail() {return email;}
		public void setEmail(String email) {
			this.email=email;
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
		
		public Integer getIdRuolo() {return idRuolo;}
		public void setIdRuolo(Integer idRuolo) {
			this.idRuolo=idRuolo;
		}
		
		public String getNomeRuolo() {return nomeRuolo;}
		public void setNomeRuolo(String nomeRuolo) {
			this.nomeRuolo=nomeRuolo;
		}
		
		public Integer getCodiceVerifica() { return codiceVerifica; }
	    public void setCodiceVerifica(Integer codiceVerifica) {
	        this.codiceVerifica = codiceVerifica;
	    }
}
