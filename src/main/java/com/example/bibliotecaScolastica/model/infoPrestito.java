package com.example.bibliotecaScolastica.model;

import java.sql.Timestamp;

public class infoPrestito {
    private Long idUtente;
    private Long idLibro;
    private String nomeCognome;
    private Timestamp dataFine;

    public infoPrestito(Long idUtente, Long idLibro, String nomeCognome, Timestamp dataFine2) {
        this.idUtente = idUtente;
        this.idLibro = idLibro;
        this.nomeCognome = nomeCognome;
        this.dataFine = dataFine2;
    }

    // Getter e setter
    public Long getIdUtente() { return idUtente; }
    public void setIdUtente(Long idUtente) { this.idUtente = idUtente; }

    public Long getIdLibro() { return idLibro; }
    public void setIdLibro(Long idLibro) { this.idLibro = idLibro; }

    public String getNomeCognome() { return nomeCognome; }
    public void setNomeCognome(String nomeCognome) { this.nomeCognome = nomeCognome; }

    public Timestamp getDataFine() { return dataFine; }
    public void setDataFine(Timestamp dataFine) { this.dataFine = dataFine; }
}
