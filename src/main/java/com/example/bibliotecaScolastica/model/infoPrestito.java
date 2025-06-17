package com.example.bibliotecaScolastica.model;

public class infoPrestito {
	private Long idUtente;
	private Long idLibro;
	private String nome;
	private String cognome;
	private String classe;
	
	public infoPrestito(Long idUtente, Long idLibro,String nome, String cognome,String classe) {
		this.idLibro=idLibro;
		this.idUtente=idUtente;
		this.nome=nome;
		this.cognome=cognome;
		this.classe=classe;
	}
	
	//Metodi getter e setter
	public Long getIdUtente() {return idUtente;}
	public void setIdUtente(Long idUtente){
		this.idUtente=idUtente;
	}
	public Long getIdLibro() {return idLibro;}
	public void setIdLibro(Long idLibro){
		this.idLibro=idLibro;
	}
	public String getNome() {return nome;}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	public String getClasse() {return classe;}
	public void setClasse(String classe) {
		this.classe=classe;
	}
}
