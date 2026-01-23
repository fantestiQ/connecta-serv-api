package com.app.coneccta.controllers;

import com.app.coneccta.domain.user.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @PostMapping("/register-user")
    public void cadastroUser(@RequestBody UserDTO response){


        }



}

