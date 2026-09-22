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

    protected void ajouterCoupSiValide(Plateau plateau, List<Case> coups, int x, int y) {
        Coordonee coordonnee = new Coordonee(x, y);
        if (!plateau.estDansPlateau(coordonnee)) {
            return;
        }
        Case caseCible = plateau.getCase(coordonnee);
        if (caseCible.estVide() || caseCible.getPiece().getCouleur() != couleur) {
            coups.add(caseCible);
        }
    }

    protected void ajouterCoupsEnLigne(Plateau plateau, List<Case> coups, int[][] directions) {
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

    public abstract List<Case> getCoupsPossibles(Plateau plateau);

}