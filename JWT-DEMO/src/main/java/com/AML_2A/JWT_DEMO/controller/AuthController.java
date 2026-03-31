package com.AML_2A.JWT_DEMO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AML_2A.JWT_DEMO.service.AuthService;

@RestController
public class AuthController {
	@Autowired
    AuthService service;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to JWT Authentication Demo! Available endpoints: POST /api/login, GET /api/hello";
    }

    @PostMapping("/api/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
    	System.out.println("Login API Hit");
        return service.login(username, password);
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello! JWT Authentication Successful";
    }
}