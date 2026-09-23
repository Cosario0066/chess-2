package com.cosario.chess2.tests;

import com.cosario.chess2.model.*;

public class TestJeu {
    public static void main(String[] args) {
        Jeu j = new Jeu();
        System.out.print(j.getPlateau());
        j.calculScore();
        System.out.println();
        System.out.println("Score : " + j.getScore());
        j.getPlateau().deplacementPiece(j.accederPiece(5,1),new Coordonnee(5,3),j.getTour());
        System.out.print(j.getPlateau());
        System.out.println();
        System.out.println();
        j.getPlateau().deplacementPiece(j.accederPiece(4,0), new Coordonnee(9,5),j.getTour());
        System.out.print(j.getPlateau());
        System.out.println();
        System.out.println();
        j.getPlateau().deplacementPiece(j.accederPiece(9,5), new Coordonnee(6,8),j.getTour());
        System.out.print(j.getPlateau());
        System.out.println();
        System.out.println();
        j.tourSuivant();
        j.testCheck();
        System.out.println(j.isCheck());





    }


}
