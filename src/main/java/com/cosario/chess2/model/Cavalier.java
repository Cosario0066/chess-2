package com.cosario.chess2.model;

import java.util.ArrayList;

public class Cavalier extends Piece {
    public Cavalier(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        Coordonee position = getCaseActuelle().getCoordonee();
        int[][] mouvements = {
                {-1, -2}, {1, -2}, {-2, -1}, {2, -1},
                {-2, 1}, {2, 1}, {-1, 2}, {1, 2}
        };
        for (int[] mouvement : mouvements) {
            ajouterCoupSiValide(plateau, coupsPossibles,
                    position.getX() + mouvement[0], position.getY() + mouvement[1]);
        }
        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "N" : "n";
    }
}
