package com.cosario.chess2.model;

import lombok.Setter;

import java.util.List;

public abstract class Piece {
    private Couleur couleur;
    private Coordonee coordoneeActuelle;
    @Setter
    private boolean aDejaBouge;

    public Piece(Couleur couleur, int x, int y) {
        this.couleur = couleur;
        this.aDejaBouge = false;
        this.coordoneeActuelle = new Coordonee(x,y);
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Coordonee getCoordoneeActuelle() {
        return coordoneeActuelle;
    }

    void setCoordoneeActuelle(Coordonee coordoneeActuelle) {
        this.coordoneeActuelle = coordoneeActuelle;
    }

    public boolean isADejaBouge() {
        return aDejaBouge;
    }

    abstract List<Case> getCoupsPossibles(Plateau plateau);

}