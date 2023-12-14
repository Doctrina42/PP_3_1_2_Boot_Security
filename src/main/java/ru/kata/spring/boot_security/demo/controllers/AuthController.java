package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/")
    private String showWelcomePage() {
        return "welcome";
    }

    @GetMapping("/login")
    public String getAuthenticated() {
        return "login";
    }
}
