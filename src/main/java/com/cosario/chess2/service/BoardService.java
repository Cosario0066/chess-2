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

        // Créer des pions blancs et noirs
        for (int i = 0; i < 10; i++) {
            new Pion(plateau, new Coordonee(i, 1), Couleur.BLANC);
            new Pion(plateau, new Coordonee(i, 8), Couleur.NOIR);
        }

        // Créer les rois
        new Roi(plateau, new Coordonee(5, 0), Couleur.BLANC);
        new Roi(plateau, new Coordonee(5, 9), Couleur.NOIR);
        new Reine(plateau, new Coordonee(4, 0), Couleur.BLANC);
        new Reine(plateau, new Coordonee(4, 9), Couleur.NOIR);
        new Fou(plateau, new Coordonee(3, 0), Couleur.BLANC);
        new Fou(plateau, new Coordonee(6, 0), Couleur.BLANC);
        new Fou(plateau, new Coordonee(3, 9), Couleur.NOIR);
        new Fou(plateau, new Coordonee(6, 9), Couleur.NOIR);
        new Cavalier(plateau, new Coordonee(2, 0), Couleur.BLANC);
        new Cavalier(plateau, new Coordonee(7, 0), Couleur.BLANC);
        new Cavalier(plateau, new Coordonee(2, 9), Couleur.NOIR);
        new Cavalier(plateau, new Coordonee(7, 9), Couleur.NOIR);
        new Tour(plateau, new Coordonee(1, 0), Couleur.BLANC);
        new Tour(plateau, new Coordonee(8, 0), Couleur.BLANC);
        new Tour(plateau, new Coordonee(1, 9), Couleur.NOIR);
        new Tour(plateau, new Coordonee(8, 9), Couleur.NOIR);

        String[][] board = plateau.exporterPlateau();
        return new BoardResponse(size, board);
    }
}
