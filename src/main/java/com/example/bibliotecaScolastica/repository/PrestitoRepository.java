package com.example.bibliotecaScolastica.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.model.infoPrestito;
@Repository
public interface PrestitoRepository extends JpaRepository<Prestito, Long> {
    /*API per la conclusione del prestito
     * Popola la colonna dataRestituzione
     * Aumenta di uno la disponibilità del libro
     * Estrae il nome e il cognome dell'utente 
     * */
	@Modifying
    @Query(value = "UPDATE schemabiblioteca.prestito SET datarestituzione = CURRENT_TIMESTAMP WHERE idprestito= :idPrestito AND datarestituzione IS NULL", nativeQuery = true)
    int aggiornaDataRestituzione(@Param("idPrestito") Long idPrestito);

    @Modifying
    @Query(value = "UPDATE schemabiblioteca.libro SET disponibilita = disponibilita + 1 WHERE idlibro = :idLibro", nativeQuery = true)
    int incrementaDisponibilita(@Param("idLibro") Long idLibro);

    @Query(value = "SELECT CONCAT(u.nome, ' ', u.cognome) FROM schemabiblioteca.utente u WHERE u.idutente = :idUtente", nativeQuery = true)
    String getNomeCognomeUtente(@Param("idUtente") Long idUtente);
    
    //API per la restituzione dei prestiti attivi
    @Query(value = """
    		SELECT p.idprestito,u.idutente, p.idlibro, CONCAT(u.nome, ' ', u.cognome) AS nomeCognome,p.dataInizio, p.datafine, l.titolo
    		FROM schemabiblioteca.prestito p
    		INNER JOIN schemabiblioteca.utente u ON p.idutente = u.idutente
    		INNER JOIN schemabiblioteca.libro l ON p.idlibro = l.idlibro
    		WHERE p.datarestituzione IS NULL
    		AND (:idLibro IS NULL OR p.idlibro = :idLibro)
    	""", nativeQuery = true)
   	List<Object[]> findAllPrestiti(@Param("idLibro") Long idLibro);
   	
   	// API per la restituzione dei prestiti conclusi 
   	@Query(value = """
   		    SELECT 
   		    	p.idprestito,
   		        u.idutente, 
   		        p.idlibro, 
   		        CONCAT(u.nome, ' ', u.cognome) AS nomeCognome, 
   		        p.datainizio,
   		        p.datafine,
   		        p.datarestituzione,
   		        l.titolo
   		    FROM schemabiblioteca.prestito p
   		    INNER JOIN schemabiblioteca.utente u ON p.idutente = u.idutente
   		    INNER JOIN schemabiblioteca.libro l ON p.idlibro = l.idlibro
   		    WHERE p.datarestituzione IS NOT NULL
   		      AND (:idLibro IS NULL OR p.idlibro = :idLibro)
   		    """, nativeQuery = true)
   		List<Object[]> findAllPrestitiConclusi(@Param("idLibro") Long idLibro);




}
