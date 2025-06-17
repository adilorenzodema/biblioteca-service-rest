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
	
    List<Libro> findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO schemabiblioteca.prestito (idlibro,idalunno,datainizio,datafine,datacreazione,datamodifica)"+"VALUES:(idLibro,idAlunno,dataInizio,dataFine,dataCreazione,dataModifica",nativeQuery=true)
	void concediPrestito(
			@Param("idLibro") Long idLibro,
			@Param ("idAlunno") Long idAlunno,
			@Param ("dataInizio") LocalDateTime dataInizio,
			@Param ("dataFine") LocalDateTime dataFine,
			@Param ("dataCreazione") LocalDateTime dataCreazione,
			@Param ("dataModifica") LocalDateTime dataModifica
			
	);
}