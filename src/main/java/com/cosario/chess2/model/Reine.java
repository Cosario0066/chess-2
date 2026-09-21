package com.cosario.chess2.model;

import java.util.ArrayList;

public class Reine extends Piece {
    public Reine(Plateau plateau, Coordonee coordonee, Couleur couleur) {
        super(plateau, coordonee, couleur);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        // Todo: Implement the logic for the possible moves of the queen
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "Q" : "q";
    }
}
