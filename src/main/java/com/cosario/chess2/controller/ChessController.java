package com.cosario.chess2.controller;

import com.cosario.chess2.dto.ChessStatusResponse;
import com.cosario.chess2.service.ChessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChessController {

    private final ChessService chessService;

    public ChessController(ChessService chessService) {
        this.chessService = chessService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return chessService.getWelcomeMessage();
    }

    @GetMapping("/status")
    public ChessStatusResponse getStatus() {
        return chessService.getStatus();
    }
}