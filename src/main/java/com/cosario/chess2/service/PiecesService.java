package com.cosario.chess2.service;

import com.cosario.chess2.dto.PiecesResponse;
import com.cosario.chess2.model.Case;
import com.cosario.chess2.model.Coordonee;
import com.cosario.chess2.model.Piece;
import com.cosario.chess2.model.Plateau;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiecesService {
    private final BoardService boardService;

    public PiecesService(BoardService boardService) {
        this.boardService = boardService;
    }

    public PiecesResponse getPossibleMoves(int x, int y) {
        Plateau plateau = boardService.createPlateau();
        Case selectedCase = plateau.getCase(new Coordonee(x, y));
        Piece piece = selectedCase.getPiece();

        if (piece == null) {
            return new PiecesResponse(new String[0]);
        }

        List<Case> possibleCases = piece.getCoupsPossibles();
        String[] possibleMoves = possibleCases.stream()
                .map(Case::getCoordonee)
                .map(coord -> coord.getX() + "," + coord.getY())
                .toArray(String[]::new);
        return new PiecesResponse(possibleMoves);
    }
}
