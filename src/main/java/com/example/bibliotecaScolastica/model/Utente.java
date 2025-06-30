package com.example.bibliotecaScolastica.model;

import java.time.LocalDateTime;
import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "utente", schema = "schemabiblioteca")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idutente")
	private Integer idUtente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="codicefiscale")
	private String codiceFiscale;
	
	@Column(name="classe")
	private String classe;
	
	@Column(name="email")
	private String email;
	
	@Column(name = "codiceverifica")
	private Integer  codiceVerifica;
	
	@Column(name="datacreazione")
	private Timestamp dataCreazione;
	
	@Column(name="datamodifica")
	private Timestamp dataModifica;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private Boolean active;
	
	@Column(name = "idruolo")
	private Integer  idRuolo;
	
	@Transient
    private String nomeRuolo;
	
	public Utente() { }
	
	public Utente (Integer idUtente, String nome, String cognome, String codiceFiscale, String classe,String email, Integer  codiceVerifica, Timestamp dataCreazione, Timestamp dataModifica,String username,String password,Boolean active,Integer  idRuolo) {
		this.idUtente=idUtente;
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.classe=classe;
		this.email=email;
		this.codiceVerifica=codiceVerifica;
		this.dataCreazione=dataCreazione;
		this.dataModifica=dataModifica;
		this.username=username;
		this.password=password;
		this.active=active;
		this.idRuolo=idRuolo;
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
	
	public Integer  getCodiceVerifica() {return codiceVerifica;}
	public void setCodiceVerifica(Integer  codiceVerifica) {
		this.codiceVerifica=codiceVerifica;
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
	
	public Integer  getIdRuolo() {return idRuolo;}
	public void setIdRuolo(Integer  idRuolo) {
		this.idRuolo=idRuolo;
	}
	public String getNomeRuolo() {
	    return nomeRuolo;
	}

	public void setNomeRuolo(String nomeRuolo) {
	    this.nomeRuolo = nomeRuolo;
	}
}
