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

    protected void ajouterCoupSiValide(List<Case> coups, int x, int y) {
        Plateau plateau = this.getPlateau();
        Coordonee coordonnee = new Coordonee(x, y);
        if (!plateau.estDansPlateau(coordonnee)) {
            return;
        }
        Case caseCible = plateau.getCase(coordonnee);
        if (caseCible.estVide() || caseCible.getPiece().getCouleur() != couleur) {
            coups.add(caseCible);
        }
    }

    protected void ajouterCoupsEnLigne(List<Case> coups, int[][] directions) {
        Plateau plateau = this.getPlateau();
        Coordonee position = caseActuelle.getCoordonee();
        for (int[] direction : directions) {
            int x = position.getX() + direction[0];
            int y = position.getY() + direction[1];
            while (plateau.estDansPlateau(new Coordonee(x, y))) {
                Case caseCible = plateau.getCase(new Coordonee(x, y));
                if (caseCible.estVide()) {
                    coups.add(caseCible);
                } else {
                    if (caseCible.getPiece().getCouleur() != couleur) {
                        coups.add(caseCible);
                    }
                    break;
                }
                x += direction[0];
                y += direction[1];
            }
        }
    }

    public abstract List<Case> getCoupsPossibles();

}