package com.cosario.chess2.dto;

import java.time.Instant;

public record ChessStatusResponse(String status, String message, Instant timestamp) {
}
