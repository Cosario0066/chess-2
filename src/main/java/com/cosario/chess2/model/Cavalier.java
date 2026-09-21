package com.cosario.chess2.model;

import java.util.ArrayList;

public class Cavalier extends Piece {
    public Cavalier(Plateau plateau, Coordonee coordonee, Couleur couleur) {
        super(plateau, coordonee, couleur);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        // Todo: Implement the logic for the possible moves of the knight
        return new ArrayList<>();
    }
}
