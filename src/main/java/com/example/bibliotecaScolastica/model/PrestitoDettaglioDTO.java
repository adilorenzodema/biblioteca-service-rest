package com.example.bibliotecaScolastica.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PrestitoDettaglioDTO {
    private Long idPrestito;
    private Long idUtente;
    private Long idLibro;
    private String nomeCognome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp dataInizio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp dataFine;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp dataRestituzione;

    private String titoloLibro;
    private String autore;
    private String casaEditrice;
    private String genere;
    private String link;

    public PrestitoDettaglioDTO() {}

    public PrestitoDettaglioDTO(Long idPrestito, Long idUtente, Long idLibro, String nomeCognome,
                               Timestamp dataInizio, Timestamp dataFine, Timestamp dataRestituzione,
                               String titoloLibro, String autore, String casaEditrice, String genere, String link) {
        this.idPrestito = idPrestito;
        this.idUtente = idUtente;
        this.idLibro = idLibro;
        this.nomeCognome = nomeCognome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.dataRestituzione = dataRestituzione;
        this.titoloLibro = titoloLibro;
        this.autore = autore;
        this.casaEditrice = casaEditrice;
        this.genere = genere;
        this.link = link;
    }

    // getter e setter per tutti i campi (generati automaticamente o scritti manualmente)
    public Long getIdPrestito() { return idPrestito; }
    public void setIdPrestito(Long idPrestito) { this.idPrestito = idPrestito; }

    public Long getIdUtente() { return idUtente; }
    public void setIdUtente(Long idUtente) { this.idUtente = idUtente; }

    public Long getIdLibro() { return idLibro; }
    public void setIdLibro(Long idLibro) { this.idLibro = idLibro; }

    public String getNomeCognome() { return nomeCognome; }
    public void setNomeCognome(String nomeCognome) { this.nomeCognome = nomeCognome; }

    public Timestamp getDataInizio() { return dataInizio; }
    public void setDataInizio(Timestamp dataInizio) { this.dataInizio = dataInizio; }

    public Timestamp getDataFine() { return dataFine; }
    public void setDataFine(Timestamp dataFine) { this.dataFine = dataFine; }

    public Timestamp getDataRestituzione() { return dataRestituzione; }
    public void setDataRestituzione(Timestamp dataRestituzione) { this.dataRestituzione = dataRestituzione; }

    public String getTitoloLibro() { return titoloLibro; }
    public void setTitoloLibro(String titoloLibro) { this.titoloLibro = titoloLibro; }

    public String getAutore() { return autore; }
    public void setAutore(String autore) { this.autore = autore; }

    public String getCasaEditrice() { return casaEditrice; }
    public void setCasaEditrice(String casaEditrice) { this.casaEditrice = casaEditrice; }

    public String getGenere() { return genere; }
    public void setGenere(String genere) { this.genere = genere; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}
