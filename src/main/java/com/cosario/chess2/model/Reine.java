package com.cosario.chess2.model;

import java.util.ArrayList;

public class Reine extends Piece {
    public Reine(int x, int y, Couleur couleur) {
        super(couleur, x, y);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        // Todo: Implement the logic for the possible moves of the king
        return new ArrayList<>();
    }
}
