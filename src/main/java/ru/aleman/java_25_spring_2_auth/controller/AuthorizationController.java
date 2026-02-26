package ru.aleman.java_25_spring_2_auth.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.aleman.java_25_spring_2_auth.repository.model.User;
import ru.aleman.java_25_spring_2_auth.service.AuthorizationService;
import ru.aleman.java_25_spring_2_auth.service.dictionary.Authorities;

import java.util.List;

@RestController
public class AuthorizationController {
    // @Autowired
    private AuthorizationService service;

    // @Autowired
    // public void setService(AuthorizationService service) {
    //      this.service = service;
    // }

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @GetMapping("/authorize2")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}