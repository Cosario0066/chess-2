package com.cosario.chess2.tests;

import com.cosario.chess2.model.*;

public class TestBandit {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        p.initialisationPlateau();
        System.out.println(p);

        Bandit v = new Bandit(5, 5, Couleur.BLANC, p);
        System.out.println(p);

        Fou f2 = new Fou(6, 6, Couleur.NOIR, p);
        System.out.println(p);

        Fou f3 = new Fou(4, 4, Couleur.BLANC, p);
        System.out.println(p);

        Pion p1 = new Pion(4, 6, Couleur.BLANC, p);

        Pion p2 = new Pion(6, 4, Couleur.NOIR, p);
        System.out.println(p);

        Reine q = new Reine(4,5,Couleur.NOIR,p);

        Reine q1 = new Reine(5,3,Couleur.NOIR,p);
        System.out.println(p);

        for (Case c : v.getCoupsPossibles()) {
            System.out.print(c.getCoordonnee());
        }

        p.deplacementPiece(v, new Coordonnee(5,3), v.getCouleur());
        System.out.println(p);


    }
}
