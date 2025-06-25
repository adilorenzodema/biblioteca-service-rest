package com.example.bibliotecaScolastica.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaScolastica.model.Prestito;
@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Long> {
    @Modifying
    @Query(value = "UPDATE schemabiblioteca.prestito SET datarestituzione = CURRENT_TIMESTAMP WHERE idprestito= :idPrestito AND datarestituzione IS NULL", nativeQuery = true)
    int aggiornaDataRestituzione(@Param("idPrestito") Long idPrestito);

    @Modifying
    @Query(value = "UPDATE schemabiblioteca.libro SET disponibilita = disponibilita + 1 WHERE idlibro = :idLibro", nativeQuery = true)
    int incrementaDisponibilita(@Param("idLibro") Long idLibro);

    @Query(value = "SELECT CONCAT(u.nome, ' ', u.cognome) FROM schemabiblioteca.utente u WHERE u.idutente = :idUtente", nativeQuery = true)
    String getNomeCognomeUtente(@Param("idUtente") Long idUtente);

}
