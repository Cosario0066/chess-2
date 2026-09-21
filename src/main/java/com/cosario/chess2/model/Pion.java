package com.cosario.chess2.model;

import java.util.ArrayList;

public class Pion extends Piece {

    public Pion(Case caseActuelle, Couleur couleur) {
        super(couleur, caseActuelle);
        caseActuelle.placerPiece(this);
    }

    @Override
    public ArrayList<Case> getCoupsPossibles(Plateau plateau) {
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        Coordonee coordActuelle = this.getCaseActuelle().getCoordonee();
        int direction = (this.getCouleur() == Couleur.BLANC) ? 1 : -1;

        // Déplacement d'une case en avant
        Coordonee coordAvant = new Coordonee(coordActuelle.getX(), coordActuelle.getY() + direction);
        if (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));

            // Déplacement de deux cases en avant si le pion n'a pas encore bougé
            if (!this.isADejaBouge()) {
                Coordonee coordDeuxAvant = new Coordonee(coordActuelle.getX(), coordActuelle.getY() + 2 * direction);
                if (plateau.estDansPlateau(coordDeuxAvant) && plateau.estCaseVide(coordDeuxAvant)) {
                    coupsPossibles.add(plateau.getCase(coordDeuxAvant));
                }
            }
        }

        // Capture diagonale à gauche
        Coordonee coordDiagGauche = new Coordonee(coordActuelle.getX() - 1, coordActuelle.getY() + direction);
        if (plateau.estCaseOccupeeParAdversaire(coordDiagGauche, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordDiagGauche));
        }

        // Capture diagonale à droite
        Coordonee coordDiagDroite = new Coordonee(coordActuelle.getX() + 1, coordActuelle.getY() + direction);
        if (plateau.estCaseOccupeeParAdversaire(coordDiagDroite, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordDiagDroite));
        }

        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "P" : "p";
    }

}
