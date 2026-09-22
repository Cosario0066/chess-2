package com.cosario.chess2.tests;

import com.cosario.chess2.Chess2Application;
import com.cosario.chess2.model.*;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;

public class TestFou {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        p.initialisationPlateau();
        System.out.println(p);

        Fou f = new Fou(5,5,Couleur.BLANC);
        p.placerPiece(f);
        System.out.println(p);

        Fou f2 = new Fou(6,6, Couleur.NOIR);
        p.placerPiece(f2);
        System.out.println(p);

        for (Case c : f.getCoupsPossibles(p)) {
            System.out.println(c.getCoordonee());
        }
    }
}
