package com.cosario.chess2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Bandit extends Piece {

    public Bandit(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        Plateau plateau = this.getPlateau();
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        Coordonnee coordActuelle = this.getCaseActuelle().getCoordonnee();

        int[][] directionsDiag = {
                {-1, 1}, {1, 1}, {-1, -1}, {1, -1}
        };
        int[][] directionsDroit = {
                {2,0}, {-2,0}, {0,2}, {0,-2}
        };
        int[][] directionsDroitTest = {
                {1,0}, {-1,0}, {0,1}, {0,-1}
        };


        // Parcourir toutes les directions possibles
        for  (int[] direction : directionsDiag) {
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
        for (int indice = 0; indice < 4; indice++){
            int newX = coordActuelle.getX() + directionsDroit[indice][0];
            int newY = coordActuelle.getY() + directionsDroit[indice][1];
            int midX = coordActuelle.getX() + directionsDroitTest[indice][0];
            int midY = coordActuelle.getY() + directionsDroitTest[indice][1];

            Coordonnee nouvelleCoordonnee = new Coordonnee(newX, newY);
            Coordonnee coordonneeMid = new Coordonnee(midX, midY);
            if (!plateau.estDansPlateau(nouvelleCoordonnee)) {
                continue;
            }
            Case caseCible = plateau.getCase(nouvelleCoordonnee);
            Case caseMid = plateau.getCase(coordonneeMid);
            // Vérifier si la case cible est vide ou contient une pièce ennemie
            if (caseMid.estVide() && (caseCible.estVide() || caseCible.getPiece().getCouleur() != this.getCouleur())) {
                coupsPossibles.add(caseCible);
            }
                    }
        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "V" : "v";
    }
}