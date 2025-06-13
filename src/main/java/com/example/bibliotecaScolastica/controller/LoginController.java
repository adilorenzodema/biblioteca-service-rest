package com.example.bibliotecaScolastica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaScolastica.model.User;
import com.example.bibliotecaScolastica.service.LoginService;


@RestController
@RequestMapping("/api")
public class LoginController {
	private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            boolean loginCorretto = loginService.checkUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(loginCorretto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}