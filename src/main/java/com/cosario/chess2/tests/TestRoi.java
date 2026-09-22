package com.cosario.chess2.tests;

import com.cosario.chess2.model.*;

public class TestRoi {
    public static void main(String[] args) {
        Plateau plateau = new Plateau();

        Roi roi = new Roi(plateau, new Coordonee(4, 4), Couleur.BLANC);

        // Une case alliée ne doit pas être proposée comme destination.
        Pion pieceAlliee = new Pion(plateau, new Coordonee(3, 3), Couleur.BLANC);
        // Une case ennemie doit rester accessible pour une capture.
        Pion pieceAdverse = new Pion(plateau, new Coordonee(5, 5), Couleur.NOIR);


        System.out.println("Plateau après placement du roi et des pièces :");
        System.out.println(plateau);

        System.out.println("Coups possibles pour le roi blanc :");
        for (Case casePossible : roi.getCoupsPossibles(plateau)) {
            System.out.println(casePossible.getCoordonee());
        }

    }
}
