package com.cosario.chess2.service;

import com.cosario.chess2.dto.BoardResponse;
import com.cosario.chess2.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    public BoardResponse getBoard() {
        int size = 10;
        Plateau plateau = new Plateau();
        plateau.initialisationPlateau();
        for  (int i = 0; i < 10; i++) {
            new Pion(plateau, new Coordonee(i, 1), Couleur.BLANC);
            new Pion(plateau, new Coordonee(i, 8), Couleur.NOIR);
        }
        new Roi(plateau, new Coordonee(4, 0), Couleur.BLANC);
        new Roi(plateau, new Coordonee(4, 9), Couleur.NOIR);


        String[][] board = plateau.exporterPlateau();

        return new BoardResponse(size, board);
    }
}
