package com.cosario.chess2.service;

import com.cosario.chess2.dto.ChessStatusResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ChessService {

    public String getWelcomeMessage() {
        return "Le serveur du jeu d'échecs est en ligne !";
    }

    public String getStatusMessage() {
        return "Le serveur du jeu d'échecs est en cours d'exécution !";
    }

    public ChessStatusResponse getStatus() {
        return new ChessStatusResponse("RUNNING", getStatusMessage(), Instant.now());
    }
}
