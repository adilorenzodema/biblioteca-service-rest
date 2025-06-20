package com.example.bibliotecaScolastica.model;

public class ModificaLibroDTO extends AggiungiLibroDTO {
	private Long idLibro;
	
    public ModificaLibroDTO(Long idLibro, String titolo, String autore, String casaEditrice, String genere, String iban, int disponibilita, String link) {
        super(titolo, autore, casaEditrice, genere, iban, disponibilita, link);
        this.idLibro = idLibro;
    }

    // Getter e setter per idLibro
    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }
}
