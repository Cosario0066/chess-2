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

    public void placerPiece(Piece piece) {
        if (piece != null && piece.getCoordoneeActuelle() != null) {
            Coordonee coordonee = piece.getCoordoneeActuelle();
            if (this.estDansPlateau(coordonee)) {
                Case caseActuelle = this.getCase(coordonee);
                if (!this.estCaseOccupeeParAdversaire(coordonee, piece.getCouleur())) {
                    caseActuelle.setPiece(piece);
                }
            }
        }
    }


    public void retirerPiece(Piece piece) {
        if (piece != null && piece.getCoordoneeActuelle() != null) {
            Coordonee coordonee = piece.getCoordoneeActuelle();
            if (this.estDansPlateau(coordonee)) {
                Case caseActuelle = this.getCase(coordonee);
                caseActuelle.setPiece(null);
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
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean estCaseOccupeeParAdversaire(Coordonee coord, Couleur couleur) {
        System.out.println("case non vide ? " + !estCaseVide(coord));
        System.out.println("piece de couleur opposé ? " + this.getCase(coord).getPiece().getCouleur());
        System.out.println("Quelle pièce ? " + this.getCase(coord).getPiece());
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