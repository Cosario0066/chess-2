package com.cosario.chess2.model;

import java.util.List;

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
    public Case getCase(int x, int y) {
        return grille[x][y];
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
        return this.getCase(coord).estVide();
    }

    public boolean estDansPlateau(Coordonee coord) {
        return coord.getX() >= 0 && coord.getX() < 10 && coord.getY() >= 0 && coord.getY() < 10;
    }

    public void afficherPlateau() {
        for (int y = 9; y >= 0; y--) {
            System.out.print(y + " ");
            for (int x = 9; x >= 0; x--) {
                System.out.print(grille[x][y] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int x = 9; x >= 0; x--) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public boolean estCaseOccupeeParAdversaire(Coordonee coord, Couleur couleur) {
        return estDansPlateau(coord) && !estCaseVide(coord) && this.getCase(coord).getPiece().getCouleur() != couleur;
    }

    public String [][] exporterPlateau() {
        String[][] plateauExport = new String[10][10];
        for (int displayRow = 0; displayRow < 10; displayRow++) {
            int y = 9 - displayRow;
            for (int displayX = 0; displayX < 10; displayX++) {
                int x = 9 - displayX;
                plateauExport[displayRow][displayX] = grille[x][y].toString();
            }
        }
        return plateauExport;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 9; y >= 0; y--) {
            sb.append(y).append(" ");
            for (int x = 9; x >= 0; x--) {
                sb.append(grille[x][y].toString()).append(" ");
            }
            sb.append("\n");
        }
        sb.append("  ");
        for (int x = 9; x >= 0; x--) {
            sb.append(x).append(" ");
        }
        return sb.toString();
    }

    public void deplacementPiece(Piece piece, Coordonee newCoord) {
        if (piece == null) {
            throw new IllegalArgumentException("Aucune pièce sur la case de départ");
        }

        List<Case> coupsPossibles = piece.getCoupsPossibles();
        Case target = this.getCase(newCoord);
        if (!coupsPossibles.contains(target)) {
            throw new IllegalArgumentException("Déplacement impossible vers " + newCoord);
        }

        piece.getCaseActuelle().retirerPiece();
        target.setPiece(piece);
        piece.setADejaBouge(true);
    }
}