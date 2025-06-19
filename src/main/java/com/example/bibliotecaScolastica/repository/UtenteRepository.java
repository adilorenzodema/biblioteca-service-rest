package com.example.bibliotecaScolastica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.model.UtenteDTO;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	//API estrazione tutti gli utenti presenti 
	@Query(value = "SELECT u.*, r.ruolo AS nomeRuolo " + // Aggiunto spazio dopo nomeRuolo
	          "FROM schemabiblioteca.utente u " +
	          "LEFT JOIN schemabiblioteca.ruolo r ON u.idruolo = r.idruolo " +  
	          "WHERE (:nomeRuolo IS NULL OR r.ruolo = :nomeRuolo)",  
	           nativeQuery = true)
	List<UtenteDTO> findAllUtenti(@Param("nomeRuolo") String nomeRuolo);

}
