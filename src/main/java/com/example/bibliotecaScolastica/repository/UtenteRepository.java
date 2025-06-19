package com.example.bibliotecaScolastica.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.model.UtenteDTO;

import jakarta.transaction.Transactional;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	//API estrazione tutti gli utenti presenti 
	@Query(value = "SELECT u.*, r.ruolo AS nomeRuolo " + // Aggiunto spazio dopo nomeRuolo
	          "FROM schemabiblioteca.utente u " +
	          "LEFT JOIN schemabiblioteca.ruolo r ON u.idruolo = r.idruolo " +  
	          "WHERE (:nomeRuolo IS NULL OR r.ruolo = :nomeRuolo)",  
	           nativeQuery = true)
	List<UtenteDTO> findAllUtenti(@Param("nomeRuolo") String nomeRuolo);
	
	//API rimozione utente
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM schemabiblioteca.utente WHERE idutente = :idutente", nativeQuery = true)
	void deleteUtente(@Param("idutente") Long idUtente);
	
	//API aggiunta libro
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO schemabiblioteca.utente (nome, cognome, codicefiscale, classe, datacreazione, datamodifica, username, password, active, idruolo) " +
	           "VALUES (:nome, :cognome, :codiceFiscale, :classe,:dataCreazione, :dataModifica, :username, :password, :active, :idRuolo)", nativeQuery = true)
	void addUtente(
		@Param("nome") String nome,
		@Param("cognome") String cognome,
		@Param("codiceFiscale") String codiceFiscale,
		@Param("classe") String classe,
	 	@Param("dataCreazione") Timestamp timestamp,
	 	@Param("dataModifica") Timestamp dataModifica,
	 	@Param("username") String username,
	 	@Param("password") String password,
	 	@Param("active") boolean active,
	 	@Param("idRuolo") int idRuolo
	);
}
