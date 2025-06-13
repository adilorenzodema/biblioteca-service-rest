package com.example.bibliotecaScolastica.repository;

import com.example.bibliotecaScolastica.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Utente, Long> {
    @Query(value="select * FROM schemabiblioteca.utente WHERE username=:username AND password=:password",nativeQuery=true);
    
}