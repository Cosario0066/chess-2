package com.cosario.chess2.model;

import java.util.ArrayList;

public class Roi extends Piece {
    public Roi(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        // init
        Plateau plateau = this.getPlateau();
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        Coordonnee coordActuelle = this.getCaseActuelle().getCoordonnee();

        // directions possibles du roi
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        // Parcourir toutes les directions possibles
        for  (int[] direction : directions) {
            int newX = coordActuelle.getX() + direction[0];
            int newY = coordActuelle.getY() + direction[1];
            Coordonnee nouvelleCoordonnee = new Coordonnee(newX, newY);
            if (!plateau.estDansPlateau(nouvelleCoordonnee)) {
                continue;
            }
            Case caseCible = plateau.getCase(nouvelleCoordonnee);
            // Vérifier si la case cible est vide ou contient une pièce ennemie
            if (caseCible.estVide() || caseCible.getPiece().getCouleur() != this.getCouleur()) {
                coupsPossibles.add(caseCible);
            }
        }
        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "K" : "k";
    }
}
