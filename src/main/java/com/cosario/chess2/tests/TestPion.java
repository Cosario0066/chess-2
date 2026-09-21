package com.cosario.chess2.tests;
import com.cosario.chess2.model.*;

public class TestPion {
    public static void main(String[] args) {

        // Test de la classe Pion
        // Créer un pion blanc
        Pion pionBlanc = new Pion(new Case(new Coordonee(0, 0)), Couleur.BLANC);

        System.out.println("Pion blanc : " + pionBlanc);

        // Créer un pion noir
        Pion pionNoir = new Pion(new Case(new Coordonee(0, 1)), Couleur.NOIR);
        System.out.println("Pion noir : " + pionNoir);

        // Test de la méthode de déplacement du pion
        Plateau plateau = new Plateau();
        plateau.initialisationPlateau();
        plateau.getCase(new Coordonee(5, 5)).setPiece(pionBlanc);
        plateau.getCase(new Coordonee(6, 6)).setPiece(pionNoir);
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
