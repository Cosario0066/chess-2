package com.cosario.chess2.model;

import java.util.ArrayList;

public class Reine extends Piece {
    public Reine(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        // Todo: Implement the logic for the possible moves of the queen
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "Q" : "q";
    }
}
