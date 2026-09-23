package com.cosario.chess2.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

public class Pion extends Piece {
    private boolean enPassant;

    public Pion(int x, int y, Couleur couleur, Plateau plateau) {
        super(couleur, x, y, plateau);
        this.enPassant = false;
    }

    public boolean getEnPassant(){
        return this.enPassant;
    }

    @Override
    public ArrayList<Case> getCoupsPossibles() {
        Plateau plateau = this.getPlateau();
        ArrayList<Case> coupsPossibles = new ArrayList<>();
        Coordonnee coordActuelle = this.getCoordoneeActuelle();
        int direction = (this.getCouleur() == Couleur.BLANC) ? 1 : -1;

        // Déplacement d'une case en avant
        Coordonnee coordAvant = new Coordonnee(coordActuelle.getX(), coordActuelle.getY() + direction);
        if (plateau.estDansPlateau(coordAvant) && plateau.estCaseVide(coordAvant)) {
            coupsPossibles.add(plateau.getCase(coordAvant));

            // Déplacement de deux cases en avant si le pion n'a pas encore bougé
            if (!this.isADejaBouge()) {
                Coordonnee coordDeuxAvant = new Coordonnee(coordActuelle.getX(), coordActuelle.getY() + 2 * direction);
                if (plateau.estDansPlateau(coordDeuxAvant) && plateau.estCaseVide(coordDeuxAvant)) {
                    coupsPossibles.add(plateau.getCase(coordDeuxAvant));
                }
            }
        }

        // Capture diagonale vers la droite (x diminue)
        Coordonnee coordDiagDroite = new Coordonnee(coordActuelle.getX() - 1, coordActuelle.getY() + direction);
        if (plateau.estCaseOccupeeParAdversaire(coordDiagDroite, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordDiagDroite));
        }

        // Capture diagonale vers la gauche (x augmente)
        Coordonnee coordDiagGauche = new Coordonnee(coordActuelle.getX() + 1, coordActuelle.getY() + direction);
        if (plateau.estCaseOccupeeParAdversaire(coordDiagGauche, this.getCouleur())) {
            coupsPossibles.add(plateau.getCase(coordDiagGauche));
        }

        return coupsPossibles;
    }

    @Override
    public String toString() {
        return (this.getCouleur() == Couleur.BLANC) ? "P" : "p";
    }

}
