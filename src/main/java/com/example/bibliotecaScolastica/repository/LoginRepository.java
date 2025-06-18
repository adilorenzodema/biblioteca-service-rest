package com.example.bibliotecaScolastica.repository;

import com.example.bibliotecaScolastica.model.Utente;
import com.example.bibliotecaScolastica.model.UtenteDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Utente, Integer> {
    @Query(value = "SELECT utente.*, ruolo.ruolo AS nomeRuolo " +
            "FROM schemabiblioteca.utente utente " +
            "JOIN schemabiblioteca.ruolo ruolo ON utente.idruolo = ruolo.idruolo " +
            "WHERE username = :username", 
            nativeQuery = true)
    UtenteDTO checkUtente(@Param("username") String username);
}