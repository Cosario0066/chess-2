package com.cosario.chess2.model;

import java.util.ArrayList;

public class Tour extends Piece {
    public Tour(int x, int y, Couleur couleur) {
        super(couleur, x, y);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        // TODO: Implement the logic for the possible moves of the rook
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "R" : "r";
    }
}
