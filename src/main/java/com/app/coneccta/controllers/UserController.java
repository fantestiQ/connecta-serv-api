package com.app.coneccta.controllers;

import com.app.coneccta.domain.candidato.Candidato;
import com.app.coneccta.domain.requests.RequestUserCandidato;
import com.app.coneccta.domain.user.User;
import com.app.coneccta.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @PostMapping("/register-user")
    public void cadastroUser(@RequestBody @Valid RequestUserCandidato request){
        User user = User.createUserCandidato(request.user());
        Candidato candidato = Candidato.createCandidato(request.candidato(), user);
        System.out.println(candidato + "\n" + user);

    }



}

