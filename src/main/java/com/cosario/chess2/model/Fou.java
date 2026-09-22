package com.cosario.chess2.model;

import java.util.ArrayList;

public class Fou extends Piece {

    public Fou(int x, int y, Couleur couleur) {
        super(couleur, x, y);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        Coordonee coordActuelle = this.getCoordoneeActuelle();

        //Déplacement diagonale avant gauche
        Coordonee coordAvant = new Coordonee(coordActuelle.getX() - 1, coordActuelle.getY() + 1);
        while (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));
            coordAvant = new Coordonee(coordAvant.getX() - 1, coordAvant.getY() + 1);
        }
        if (plateau.estDansPlateau(coordAvant) && plateau.estCaseOccupeeParAdversaire(coordActuelle, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordAvant));
        }

        //Déplacement diagonale avant droite
        coordAvant = new Coordonee(coordActuelle.getX() + 1, coordActuelle.getY() + 1);
        while (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));
            coordAvant = new Coordonee(coordAvant.getX() + 1, coordAvant.getY() + 1);
        }
        if (plateau.estDansPlateau(coordAvant) && plateau.estCaseOccupeeParAdversaire(coordActuelle, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordAvant));
        }

        //Déplacement diagonale arriere gauche
        coordAvant = new Coordonee(coordActuelle.getX() - 1, coordActuelle.getY() - 1);
        while (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));
            coordAvant = new Coordonee(coordAvant.getX() - 1, coordAvant.getY() - 1);
        }
        if (plateau.estDansPlateau(coordAvant) && plateau.estCaseOccupeeParAdversaire(coordActuelle, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordAvant));
        }

        //Déplacement diagonale arriere droite
        coordAvant = new Coordonee(coordActuelle.getX() + 1, coordActuelle.getY() - 1);
        while (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));
            coordAvant = new Coordonee(coordAvant.getX() + 1, coordAvant.getY() - 1);
        }
        if (plateau.estDansPlateau(coordAvant) && plateau.estCaseOccupeeParAdversaire(coordActuelle, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordAvant));
        }

        return coupsPossibles;
    }


    @Override
    public Couleur getCouleur() {
        return super.getCouleur();
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "B" : "b";
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "B" : "b";
    }
}
