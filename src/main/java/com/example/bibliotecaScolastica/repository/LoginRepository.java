package com.example.bibliotecaScolastica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bibliotecaScolastica.model.Utente;

public interface LoginRepository extends JpaRepository<Utente, Long> {
	@Query(value = "SELECT * FROM schemabiblioteca.utente WHERE username = :username", nativeQuery = true)
	Utente checkUtente(@Param("username") String username);

}