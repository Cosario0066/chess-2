package com.cosario.chess2.dto;

import java.util.List;

public record BoardResponse(int size, List<List<String>> board) {
}
