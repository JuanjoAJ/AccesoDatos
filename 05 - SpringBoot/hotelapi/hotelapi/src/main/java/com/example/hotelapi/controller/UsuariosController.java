package com.example.hotelapi.controller;

import  org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {


    @GetMapping("/info")
    public String conexionCorrecta()
    {
        return "Conexión correcta";
    }
}
