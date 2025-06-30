package com.example.bibliotecaScolastica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BibliotecaScolasticaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaScolasticaServiceApplication.class, args);
	}

}
