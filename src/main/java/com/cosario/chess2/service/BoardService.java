package com.cosario.chess2.service;

import com.cosario.chess2.dto.BoardResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    public BoardResponse getBoard() {
        int size = 10;
        List<List<String>> board = new ArrayList<>();

        String[][] base = {
                {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜", "", ""},
                {"♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟", "", ""},
                {"", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", ""},
                {"♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙", "", ""},
                {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖", "", ""}
        };

        for (int row = 0; row < size; row++) {
            List<String> line = new ArrayList<>();
            for (int col = 0; col < size; col++) {
                line.add(base[row][col]);
            }
            board.add(line);
        }

        return new BoardResponse(size, board);
    }
}
