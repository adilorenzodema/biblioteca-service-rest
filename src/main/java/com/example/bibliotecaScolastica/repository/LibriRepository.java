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
	@Query(value="select * from schemabiblioteca.libro",nativeQuery=true)
	List<Libro> findAllNative();
	
	@Query(value = "SELECT l.* FROM schemabiblioteca.libro l " +
            "JOIN schemabiblioteca.prestito p ON l.idlibro = p.idlibro " +
            "WHERE p.idutente = :idUtente", nativeQuery = true)
	List<Libro> findLibriInPrestitoByUtenteId(@Param("idUtente") Long idUtente);	// LibriRepository.java
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
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM schemabiblioteca.libro WHERE idlibro = :idlibro", nativeQuery = true)
	void deleteLibro(@Param("idlibro") Long idLibro);
	
}