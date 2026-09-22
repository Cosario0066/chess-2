package com.cosario.chess2.model;

import java.util.ArrayList;

public class Tour extends Piece {
    public Tour(Plateau plateau, Coordonee coordonee, Couleur couleur) {
        super(plateau, coordonee, couleur);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        ajouterCoupsEnLigne(plateau, coupsPossibles, new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        });
        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "R" : "r";
    }
}
