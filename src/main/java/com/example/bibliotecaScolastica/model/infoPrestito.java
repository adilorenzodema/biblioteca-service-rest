package com.example.bibliotecaScolastica.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class infoPrestito {
    private Long idUtente;
    private Long idLibro;
    private String nomeCognome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp dataFine;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp dataRestituzione;


    public infoPrestito(Long idUtente, Long idLibro, String nomeCognome, Timestamp dataFine, Timestamp dataRestituzione) {
        this.idUtente = idUtente;
        this.idLibro = idLibro;
        this.nomeCognome = nomeCognome;
        this.dataFine = dataFine;
        this.dataRestituzione=dataRestituzione;
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
    
    public Timestamp getDataRestituzione() { return dataRestituzione; }
    public void setDataRestituzione(Timestamp dataRestituzione) { this.dataRestituzione = dataRestituzione; }
}
