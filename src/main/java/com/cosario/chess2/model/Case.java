package com.cosario.chess2.model;

import lombok.Getter;

import java.awt.*;

public class Case {

    @Getter
    private Piece piece;
    @Getter
    private Coordonee coordonee;

    public Case() {
        this.piece = null;
        this.coordonee = new Coordonee(0, 0);
    }

    boolean estVide() {
        return piece == null;
    }

    void placerPiece(Piece piece) {
        this.piece = piece;
    }

    void retirerPiece() {
        this.piece = null;
    }
}
