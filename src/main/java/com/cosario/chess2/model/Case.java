package com.cosario.chess2.model;

import lombok.Getter;
import lombok.Setter;

public class Case {

    @Setter
    @Getter
    private Piece piece;
    @Getter
    private Coordonee coordonee;

    public Case(Coordonee coordonee) {
        this.piece = null;
        this.coordonee = coordonee;
    }

    public boolean estVide() {
        return piece == null;
    }


    @Override
    public String toString() {
        return piece != null ? piece.toString() : ".";
    }
}
