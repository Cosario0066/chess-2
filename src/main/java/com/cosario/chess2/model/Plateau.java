package com.cosario.chess2.model;

public class Plateau {
    private Case[][] grille;

    public Plateau() {
        grille = new Case[10][10];
    }

    Case getCase(Coordonee coord) {
        return grille[coord.getX()][coord.getY()];
    }

    void initialisationPlateau() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case();
            }
        }
    }

    boolean estCaseVide(Coordonee coord) {
        return grille[coord.getX()][coord.getY()].estVide();
    }

    boolean estDansPlateau(Coordonee coord) {
        return coord.getX() >= 0 && coord.getX() < 10 && coord.getY() >= 0 && coord.getY() < 10;
    }

    void afficherPlateau() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean estCaseOccupeeParAdversaire(Coordonee coordDiagDroite, Couleur couleur) {
        return estDansPlateau(coordDiagDroite) && !estCaseVide(coordDiagDroite) && grille[coordDiagDroite.getX()][coordDiagDroite.getY()].getPiece().getCouleur() != couleur;
    }
}