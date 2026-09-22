package com.cosario.chess2.service;

import com.cosario.chess2.dto.BoardResponse;
import com.cosario.chess2.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    public BoardResponse getBoard() {
        Plateau plateau = createPlateau();

        String[][] board = plateau.exporterPlateau();
        return new BoardResponse(10, board);
    }

    public Plateau createPlateau() {
        Plateau plateau = new Plateau();
/*
        for (int i = 0; i < 10; i++) {
            new Pion(i, 1, Couleur.BLANC, plateau);
            new Pion(i, 8, Couleur.NOIR, plateau);
        }

        // Créer les rois
        new Roi(5, 0, Couleur.BLANC, plateau);
        new Roi(5, 9, Couleur.NOIR, plateau);
        new Reine(4, 0, Couleur.BLANC, plateau);
        new Reine(4, 9, Couleur.NOIR, plateau);
        new Fou(3, 0, Couleur.BLANC, plateau);
        new Fou(6, 0, Couleur.BLANC, plateau);
        new Fou(3, 9, Couleur.NOIR, plateau);
        new Fou(6, 9, Couleur.NOIR, plateau);
        new Cavalier(2, 0, Couleur.BLANC, plateau);
        new Cavalier(7, 0, Couleur.BLANC, plateau);
        new Cavalier(2, 9, Couleur.NOIR, plateau);
        new Cavalier(7, 9, Couleur.NOIR, plateau);
        new Tour(1, 0, Couleur.BLANC, plateau);
        new Tour(8, 0, Couleur.BLANC, plateau);
        new Tour(1, 9, Couleur.NOIR, plateau);
        new Tour(8, 9, Couleur.NOIR, plateau);

        return plateau;
    }
}
