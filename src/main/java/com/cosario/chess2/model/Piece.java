package com.cosario.chess2.model;

import lombok.Setter;

import java.util.List;

public abstract class Piece {
    private Couleur couleur;
    private Case caseActuelle;
    @Setter
    private boolean aDejaBouge;

    public Piece(Couleur couleur, Case caseActuelle) {
        this.couleur = couleur;
        this.caseActuelle = caseActuelle;
        this.aDejaBouge = false;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Case getCaseActuelle() {
        return caseActuelle;
    }

    public boolean isADejaBouge() {
        return aDejaBouge;
    }

    abstract List<Case> getCoupsPossibles(Plateau plateau);

}