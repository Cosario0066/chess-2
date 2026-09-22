package com.cosario.chess2.controller;

import com.cosario.chess2.dto.BoardResponse;
import com.cosario.chess2.dto.ChessStatusResponse;
import com.cosario.chess2.dto.PiecesResponse;
import com.cosario.chess2.service.BoardService;
import com.cosario.chess2.service.ChessService;
import com.cosario.chess2.service.PiecesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChessController {

    private final ChessService chessService;
    private final BoardService boardService;
    private final PiecesService piecesService;

    public ChessController(ChessService chessService, BoardService boardService, PiecesService piecesService) {
        this.chessService = chessService;
        this.boardService = boardService;
        this.piecesService = piecesService;

    }

    @GetMapping("/hello")
    public String sayHello() {
        return chessService.getWelcomeMessage();
    }

    @GetMapping("/status")
    public ChessStatusResponse getStatus() {
        return chessService.getStatus();
    }

    @GetMapping("/board")
    public BoardResponse getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/possible-moves")
    public PiecesResponse getPossibleMoves(@RequestParam int x, @RequestParam int y) {
        return piecesService.getPossibleMoves(x, y);
    }
}