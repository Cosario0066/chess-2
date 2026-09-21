package com.cosario.chess2.tests;
import com.cosario.chess2.model.*;

public class TestPion {
    public static void main(String[] args) {

        Plateau plateau = new Plateau();

        // Créer un pion blanc
        Pion pionBlanc = new Pion(plateau, new Coordonee(5, 5), Couleur.BLANC);

        System.out.println("Pion blanc : " + pionBlanc);

        // Créer un pion noir
        Pion pionNoir = new Pion(plateau, new Coordonee(6, 6), Couleur.NOIR);
        System.out.println("Pion noir : " + pionNoir);

        // Test de la méthode de déplacement du pion
        System.out.println("Plateau après placement des pions :");
        System.out.println(plateau);

        // Test des coups possibles pour le pion blanc
        System.out.println("Coups possibles pour le pion blanc :");
        for (Case c : pionBlanc.getCoupsPossibles(plateau)) {
            System.out.println(c.getCoordonee());
        }

        // Test des coups possibles pour le pion noir
        System.out.println("Coups possibles pour le pion noir :");
        for (Case c : pionNoir.getCoupsPossibles(plateau)) {
            System.out.println(c.getCoordonee());
        }
    }
}
