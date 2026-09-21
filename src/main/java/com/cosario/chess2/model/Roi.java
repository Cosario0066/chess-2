package com.cosario.chess2.model;

import java.awt.*;
import java.util.ArrayList;

public class Roi extends Piece {
    public Roi(int x, int y, Couleur couleur) {
        super(couleur, new Case(new Coordonee(x, y)));
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        // Todo: Implement the logic for the possible moves of the king
        return new ArrayList<>();
    }
}
