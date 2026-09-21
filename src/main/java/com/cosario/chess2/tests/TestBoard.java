package com.cosario.chess2.tests;

import com.cosario.chess2.model.*;

public class TestBoard {
    public static void main(String[] args) {
        // Créer un plateau
        Plateau plateau = new Plateau();

        // Créer des pions blancs et noirs
        for (int i = 0; i < 10; i++) {
            new Pion(plateau, new Coordonee(i, 1), Couleur.BLANC);
            new Pion(plateau, new Coordonee(i, 8), Couleur.NOIR);
        }

        // Créer les rois
        new Roi(plateau, new Coordonee(4, 0), Couleur.BLANC);
        new Roi(plateau, new Coordonee(4, 9), Couleur.NOIR);

        // Afficher le plateau
        System.out.println("Plateau initial :");
        plateau.afficherPlateau();
    }
}
