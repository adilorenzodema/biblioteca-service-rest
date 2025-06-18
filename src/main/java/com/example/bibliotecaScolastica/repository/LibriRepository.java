package com.example.bibliotecaScolastica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import com.example.bibliotecaScolastica.model.Libro;

import jakarta.transaction.Transactional;

@Repository
public interface LibriRepository extends JpaRepository<Libro,Long> {
	//API estrazione tutti i libri disponibili
	@Query(value="select * from schemabiblioteca.libro",nativeQuery=true)
	List<Libro> findAllNative();
	
	//API estrazione i libri di un utente
	@Query(value = "SELECT l.* FROM schemabiblioteca.libro l " +
            "JOIN schemabiblioteca.prestito p ON l.idlibro = p.idlibro " +
            "WHERE p.idutente = :idUtente", nativeQuery = true)
	List<Libro> findLibriInPrestitoByUtenteId(@Param("idUtente") Long idUtente);	// LibriRepository.java
	
	//API concessione prestito
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO schemabiblioteca.prestito (idlibro, idutente, datainizio, datafine, datacreazione, datamodifica, datarestituzione) " +
	               "VALUES (:idLibro, :idUtente, :dataInizio, :dataFine, :dataCreazione, :dataModifica, :dataRestituzione)", nativeQuery = true)
	void concediPrestito(
	    @Param("idLibro") Long idLibro,
	    @Param("idUtente") Long idUtente,
	    @Param("dataInizio") LocalDateTime dataInizio,
	    @Param("dataFine") LocalDateTime dataFine,
	    @Param("dataCreazione") LocalDateTime dataCreazione,
	    @Param("dataModifica") LocalDateTime dataModifica,
	    @Param("dataRestituzione") LocalDateTime dataRestituzione
	);
	
	//API rimozione libro
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM schemabiblioteca.libro WHERE idlibro = :idlibro", nativeQuery = true)
	void deleteLibro(@Param("idlibro") Long idLibro);
	
	
	//API aggiunta libro
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO schemabiblioteca.libro (titolo, autore, casaeditrice, genere, codiceiban, disponibilita, datacreazione, datamodifica, link) " +
            "VALUES (:titolo, :autore, :casaEditrice, :genere, :iban, :disponibilita, :dataCreazione, :dataModifica, :link)", nativeQuery = true)
	void addLibro(
	 @Param("titolo") String titolo,
	 @Param("autore") String autore,
	 @Param("casaEditrice") String casaEditrice,
	 @Param("genere") String genere,
	 @Param("iban") String iban,
	 @Param("disponibilita") int disponibilita,
	 @Param("dataCreazione") LocalDateTime dataCreazione,
	 @Param("dataModifica") LocalDateTime dataModifica,
	 @Param("link") String link
	);
	
}