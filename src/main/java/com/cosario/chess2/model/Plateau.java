package com.cosario.chess2.model;

import java.util.List;

public class Plateau {
    private Case[][] grille;

    public Plateau() {
        grille = new Case[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case(new Coordonnee(i, j));
            }
        }
    }

    public Case getCase(Coordonnee coord) {
        if (!estDansPlateau(coord)) {
            throw new IllegalArgumentException("Coordonnée hors du plateau : " + coord);
        }
        return grille[coord.getX()][coord.getY()];
    }
    public Case getCase(int x, int y) {
        return grille[x][y];
    }

    public void initialisationPlateau() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grille[i][j] == null) {
                    grille[i][j] = new Case(new Coordonnee(i, j));
                }
            }
        }
    }

    public boolean estCaseVide(Coordonnee coord) {
        if (!estDansPlateau(coord)) {
            return false;
        }
        return this.getCase(coord).estVide();
    }

    public boolean estDansPlateau(Coordonnee coord) {
        return coord.getX() >= 0 && coord.getX() < 10 && coord.getY() >= 0 && coord.getY() < 10;
    }

    public void afficherPlateau() {
        for (int y = 9; y >= 0; y--) {
            System.out.print(y + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(grille[j][y] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int x = 0; x < 10; x++) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public boolean estCaseOccupeeParAdversaire(Coordonnee coord, Couleur couleur) {
        return estDansPlateau(coord) && !estCaseVide(coord) && this.getCase(coord).getPiece().getCouleur() != couleur;
    }

    public String [][] exporterPlateau() {
        String[][] plateauExport = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                plateauExport[j][i] = grille[i][j].toString();
            }
        }
        return plateauExport;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 9; y >= 0; y--) {
            sb.append(y).append(" ");
            for (int x = 0; x < 10; x++) {
                sb.append(grille[x][y].toString()).append(" ");
            }
            sb.append("\n");
        }
        sb.append("  ");
        for (int x = 0; x < 10; x++) {
            sb.append(x).append(" ");
        }
        return sb.toString();
    }

    public void deplacementPiece(Piece piece, Coordonnee newCoord){
        List<Case> coupsPossibles = piece.getCoupsPossibles();
        if (coupsPossibles.contains(this.getCase(newCoord))){
            piece.getCaseActuelle().retirerPiece();
            this.getCase(newCoord).setPiece(piece);
            piece.setADejaBouge(true);
        }

    }

    public void initialisationPiece() {
        for (int i = 0; i < 10; i++) {
            new Pion(i, 1, Couleur.BLANC, this);
            new Pion(i, 8, Couleur.NOIR, this);
        }
        new Roi(5, 0, Couleur.BLANC, this);
        new Roi(5, 9, Couleur.NOIR, this);
        new Reine(4, 0, Couleur.BLANC, this);
        new Reine(4, 9, Couleur.NOIR, this);
        new Fou(3, 0, Couleur.BLANC, this);
        new Fou(6, 0, Couleur.BLANC, this);
        new Fou(3, 9, Couleur.NOIR, this);
        new Fou(6, 9, Couleur.NOIR, this);
        new Cavalier(2, 0, Couleur.BLANC, this);
        new Cavalier(7, 0, Couleur.BLANC, this);
        new Cavalier(2, 9, Couleur.NOIR, this);
        new Cavalier(7, 9, Couleur.NOIR, this);
        new Tour(1, 0, Couleur.BLANC, this);
        new Tour(8, 0, Couleur.BLANC, this);
        new Tour(1, 9, Couleur.NOIR, this);
        new Tour(8, 9, Couleur.NOIR, this);
    }
}