package com.cosario.chess2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Le serveur du jeu d'échecs est en ligne !";
    }
}