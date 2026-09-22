package com.cosario.chess2.model;

import java.util.ArrayList;
import java.util.List;

public class Fou extends Piece {

    public Fou(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        Plateau plateau = this.getPlateau();
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        Coordonee coordActuelle = this.getCaseActuelle().getCoordonee();

        //Déplacement diagonale avant gauche
        Coordonee coordAvant = new Coordonee(coordActuelle.getX() - 1, coordActuelle.getY() + 1);
        while (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));
            coordAvant = new Coordonee(coordAvant.getX() - 1, coordAvant.getY() + 1);
        }
        if (plateau.estDansPlateau(coordAvant)) {
            System.out.println(plateau.getCase(coordAvant));
            System.out.println(plateau.estCaseOccupeeParAdversaire(coordAvant, this.getCouleur()));
        }
        if (plateau.estDansPlateau(coordAvant) && plateau.estCaseOccupeeParAdversaire(coordAvant, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordAvant));
        }

        //Déplacement diagonale avant droite
        coordAvant = new Coordonee(coordActuelle.getX() + 1, coordActuelle.getY() + 1);
        while (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));
            coordAvant = new Coordonee(coordAvant.getX() + 1, coordAvant.getY() + 1);
        }
        if (plateau.estDansPlateau(coordAvant)) {
            System.out.println(plateau.getCase(coordAvant));
            System.out.println(plateau.estCaseOccupeeParAdversaire(coordActuelle, this.getCouleur()));
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
        if (plateau.estDansPlateau(coordAvant)) {
            System.out.println(plateau.getCase(coordAvant));
            System.out.println(plateau.estCaseOccupeeParAdversaire(coordActuelle, this.getCouleur()));
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
        if (plateau.estDansPlateau(coordAvant)) {
            System.out.println(plateau.getCase(coordAvant));
            System.out.println(plateau.estCaseOccupeeParAdversaire(coordActuelle, this.getCouleur()));
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

}
