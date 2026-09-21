package com.cosario.chess2.model;

public class Plateau {
    private Case[][] grille;

    public Plateau() {
        grille = new Case[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case(new Coordonee(i, j));
            }
        }
    }

    public Case getCase(Coordonee coord) {
        if (!estDansPlateau(coord)) {
            throw new IllegalArgumentException("Coordonnée hors du plateau : " + coord);
        }
        return grille[coord.getX()][coord.getY()];
    }

    public void initialisationPlateau() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grille[i][j] == null) {
                    grille[i][j] = new Case(new Coordonee(i, j));
                }
            }
        }
    }

    public boolean estCaseVide(Coordonee coord) {
        if (!estDansPlateau(coord)) {
            return false;
        }
        return grille[coord.getX()][coord.getY()].estVide();
    }

    public boolean estDansPlateau(Coordonee coord) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
            for (int j = 0; j < 10; j++) {
                sb.append(grille[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        sb.append("  ");
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}