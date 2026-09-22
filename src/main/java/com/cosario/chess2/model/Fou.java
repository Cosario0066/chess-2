package com.cosario.chess2.model;

import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece {

    public Fou(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        ajouterCoupsEnLigne(coupsPossibles, new int[][]{
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        });
        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "B" : "b";
    }

}
