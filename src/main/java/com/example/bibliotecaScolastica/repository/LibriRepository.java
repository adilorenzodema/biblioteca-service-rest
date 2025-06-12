package com.example.bibliotecaScolastica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.bibliotecaScolastica.model.Libro;

@Repository
public interface LibriRepository extends JpaRepository<Libro,Long> {
	@Query(value="select * from schemabiblioteca.libro",nativeQuery=true)
	List<Libro> findAllNative();
}
