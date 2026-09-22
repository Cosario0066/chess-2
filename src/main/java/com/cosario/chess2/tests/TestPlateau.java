package com.cosario.chess2.tests;

import com.cosario.chess2.model.*;

public class TestPlateau {
    public static void main(String[] args) {
        Plateau p = new Plateau();

        Pion p1 = new Pion(1, 0, Couleur.BLANC, p);
        System.out.println(p);
        for (Case c : p1.getCoupsPossibles()) {
            System.out.println(c.getCoordonnee());
        }

        p.deplacementPiece(p1, new Coordonnee(5,5));
        System.out.println(p);
        p.deplacementPiece(p1, new Coordonnee(1,2));
        System.out.println(p);

    }
}
