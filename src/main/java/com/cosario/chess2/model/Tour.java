package com.cosario.chess2.model;

import java.util.ArrayList;

public class Tour extends Piece {
    public Tour(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        // TODO: Implement the logic for the possible moves of the rook
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "R" : "r";
    }
}
