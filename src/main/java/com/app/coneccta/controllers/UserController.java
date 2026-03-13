package com.app.coneccta.controllers;

import com.app.coneccta.domain.candidato.Candidato;
import com.app.coneccta.domain.candidato.CanditatoDTO;
import com.app.coneccta.domain.user.User;
import com.app.coneccta.domain.user.UserDTO;
import com.app.coneccta.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;


    @PostMapping("/register-user")
    public void cadastroUser(@RequestBody UserDTO userDTO, CanditatoDTO canditatoDTO){
        User user = User.createUserCandidato(userDTO);
        Candidato candidato = Candidato.createCandidato(canditatoDTO, user);

    }



}

