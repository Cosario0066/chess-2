package com.cosario.chess2.model;

public class Plateau {
    private Case[][] grille;

    public Plateau() {
        grille = new Case[10][10];
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
        return grille[coord.getX()][coord.getY()];
    }
    public Case getCase(int x, int y) {
        return grille[x][y];
    }

    public void initialisationPlateau() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = new Case(new Coordonee(i, j));
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