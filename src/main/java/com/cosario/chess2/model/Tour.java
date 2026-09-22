package com.cosario.chess2.model;

import java.util.ArrayList;

public class Tour extends Piece {
    public Tour(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        ajouterCoupsEnLigne( coupsPossibles, new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        });
        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "R" : "r";
    }
}
