package com.example.bibliotecaScolastica.repository;

import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.model.UtenteDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Utente, Integer> {
    @Query(value = "SELECT \r\n"
    		+ "    u.idutente, u.nome, u.cognome, u.codicefiscale,\r\n"
    		+ "    u.classe, u.datacreazione, u.datamodifica,\r\n"
    		+ "    u.username, u.password, u.active, u.idruolo,\r\n"
    		+ "    r.ruolo AS nomeRuolo\r\n"
    		+ "FROM schemabiblioteca.utente u\r\n"
    		+ "JOIN schemabiblioteca.ruolo r ON u.idruolo = r.idruolo\r\n"
    		+ "WHERE u.username = ?\r\n"
    		+ "", 
            nativeQuery = true)
    UtenteDTO checkUtente(@Param("username") String username);
}