package com.example.bibliotecaScolastica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaScolastica.model.Libro;
import com.example.bibliotecaScolastica.repository.LoginRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {
	private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @GetMapping("/checkUser")
    public boolean checkUser(String username, String password) {
    	return true;
    }
}
