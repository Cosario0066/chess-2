package com.cosario.chess2.model;

import lombok.Setter;

import java.util.List;

public abstract class Piece {
    private Couleur couleur;
    private Case caseActuelle;
    @Setter
    private boolean aDejaBouge;

    public Piece(Plateau plateau, Coordonee coordonee, Couleur couleur) {
        this.couleur = couleur;
        this.aDejaBouge = false;
        this.caseActuelle = plateau.getCase(coordonee);
        this.caseActuelle.setPiece(this);
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Case getCaseActuelle() {
        return caseActuelle;
    }

    void setCaseActuelle(Case caseActuelle) {
        this.caseActuelle = caseActuelle;
    }

    public boolean isADejaBouge() {
        return aDejaBouge;
    }

    abstract List<Case> getCoupsPossibles(Plateau plateau);

}