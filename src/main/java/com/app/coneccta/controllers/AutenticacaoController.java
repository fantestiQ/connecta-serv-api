package com.app.coneccta.controllers;

import com.app.coneccta.domain.user.AutenticacaoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO auth){
       var token = new UsernamePasswordAuthenticationToken(auth.email(), auth.password());
       var authentication = manager.authenticate(token);

       return ResponseEntity.ok().build();
    }
}
