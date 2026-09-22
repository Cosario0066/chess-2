package com.cosario.chess2.model;

import java.util.ArrayList;

public class Cavalier extends Piece {
    public Cavalier(int x, int y, Couleur couleur) {
        super(couleur, x, y);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        // Todo: Implement the logic for the possible moves of the knight
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "N" : "n";
    }
}
