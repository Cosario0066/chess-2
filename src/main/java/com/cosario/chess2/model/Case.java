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

    public void setPiece(Piece piece) {
        if (this.piece != null && this.piece != piece && this.piece.getCaseActuelle() == this) {
            this.piece.setCaseActuelle(null);
        }
        this.piece = piece;
        if (piece != null && piece.getCaseActuelle() != this) {
            Case ancienneCase = piece.getCaseActuelle();
            if (ancienneCase != null && ancienneCase.piece == piece) {
                ancienneCase.piece = null;
            }
            piece.setCaseActuelle(this);
        }
    }

    void retirerPiece() {
        if (piece != null && piece.getCaseActuelle() == this) {
            piece.setCaseActuelle(null);
        }
        this.piece = null;
    }

    @Override
    public String toString() {
        return piece != null ? piece.toString() : ".";
    }
}
