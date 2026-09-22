package com.cosario.chess2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public abstract class Piece {
    @Getter
    private final Couleur couleur;
    @Getter
    @Setter
    private Case caseActuelle;
    @Getter
    private Plateau plateau;
    @Setter
    private boolean aDejaBouge;

    public Piece(Couleur couleur, int x, int y, Plateau plateau) {
        this.couleur = couleur;
        this.aDejaBouge = false;
        this.plateau = plateau;
        this.caseActuelle = plateau.getCase(x,y);
        this.caseActuelle.setPiece(this);
    }

    public Coordonee getCoordoneeActuelle() {
        return caseActuelle.getCoordonee();
    }

    public boolean isADejaBouge() {
        return aDejaBouge;
    }

    public abstract List<Case> getCoupsPossibles();

}