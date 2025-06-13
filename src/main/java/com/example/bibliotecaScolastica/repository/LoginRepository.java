package com.example.bibliotecaScolastica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bibliotecaScolastica.model.Utente;

public interface LoginRepository extends JpaRepository<Utente, Long> {
    @Query(value="select 1 FROM schemabiblioteca.utente WHERE username=:username",nativeQuery=true)
	Utente checkUtente(String username);
    
    
    
}