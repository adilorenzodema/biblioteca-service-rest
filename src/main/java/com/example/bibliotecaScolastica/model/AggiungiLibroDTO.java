package com.example.bibliotecaScolastica.model;


public class AggiungiLibroDTO {
	private String titolo;
	private String autore;
	private String casaEditrice;
	private String genere;
	private String iban;
	private int disponibilita;
	private String link;
	
	public AggiungiLibroDTO(String titolo, String autore, String casaEditrice, String genere, String iban, int disponibilita, String link) {
		this.titolo=titolo;
		this.autore=autore;
		this.casaEditrice=casaEditrice;
		this.genere=genere;
		this.iban=iban;
		this.disponibilita=disponibilita;
		this.link=link;
	}
	
	//Metodi getter e setter		
		public String getTitolo() {return titolo;}
		public void setTitolo (String titolo) {
			this.titolo=titolo;
		}
		
		public String getAutore() {return autore;}
		public void setAutore (String autore) {
			this.autore=autore;
		}
		
		public String getCasaEditrice() {return casaEditrice;}
		public void setCasaEditrice(String casaEditrice) {
			this.casaEditrice=casaEditrice;
		}
		public String getGenere() {return genere;}
		public void setGenere(String genere) {
			this.genere=genere;
		}
		
		public String getIban() { return iban; }
		public void setIban(String iban) {
		    this.iban = iban;
		}

		
		public int getDisponibilita() { return disponibilita;}
		public void setDisponibilita (int disponibilita) {
			this.disponibilita=disponibilita;
		}
		public String getLink() {return link;}
		public void setLink(String link) {
			this.link=link;
		}
	
}
