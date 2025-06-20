package com.example.bibliotecaScolastica.model;

public class infoPrestito {
	private Long idUtente;
	private Long idLibro;
	
	public infoPrestito(Long idUtente, Long idLibro) {
		this.idLibro=idLibro;
		this.idUtente=idUtente;
		
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
	
}
