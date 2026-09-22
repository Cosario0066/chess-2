package com.cosario.chess2.tests;

import com.cosario.chess2.model.*;

public class TestBoard {
    public static void main(String[] args) {
        // Créer un plateau
        Plateau plateau = new Plateau();

        for (int i = 0; i < 10; i++) {
            new Pion(i, 1, Couleur.BLANC, plateau);
            new Pion(i, 8, Couleur.NOIR, plateau);
        }

        // Créer les rois
        new Roi(5, 0, Couleur.BLANC, plateau);
        new Roi(5, 9, Couleur.NOIR, plateau);
        new Reine(4, 0, Couleur.BLANC, plateau);
        new Reine(4, 9, Couleur.NOIR, plateau);
        new Fou(3, 0, Couleur.BLANC, plateau);
        new Fou(6, 0, Couleur.BLANC, plateau);
        new Fou(3, 9, Couleur.NOIR, plateau);
        new Fou(6, 9, Couleur.NOIR, plateau);
        new Cavalier(2, 0, Couleur.BLANC, plateau);
        new Cavalier(7, 0, Couleur.BLANC, plateau);
        new Cavalier(2, 9, Couleur.NOIR, plateau);
        new Cavalier(7, 9, Couleur.NOIR, plateau);
        new Tour(1, 0, Couleur.BLANC, plateau);
        new Tour(8, 0, Couleur.BLANC, plateau);
        new Tour(1, 9, Couleur.NOIR, plateau);
        new Tour(8, 9, Couleur.NOIR, plateau);
        // Afficher le plateau
        System.out.println("Plateau initial :");
        plateau.afficherPlateau();
    }
}
