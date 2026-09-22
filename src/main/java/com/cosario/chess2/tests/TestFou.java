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

        Fou f = new Fou(5,5,Couleur.BLANC, p);
        System.out.println(p);

        System.out.println(f.getCoupsPossibles().toArray().length);


        Fou f2 = new Fou(6,6, Couleur.NOIR, p);
        System.out.println(p);

        Fou f3 = new Fou(4,4,Couleur.BLANC,p);
        System.out.println(p);
        Pion p1 = new Pion(4,6,Couleur.BLANC,p);

        Pion p2 = new Pion(6,4, Couleur.NOIR, p);
        System.out.println(p);

        for (Case c : f.getCoupsPossibles()) {
            System.out.print(c.getCoordonee());
        }
    }
}
