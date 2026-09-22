package com.cosario.chess2.model;

import lombok.Getter;
import lombok.Setter;

public class Jeu {
    @Setter
    private int score;
    @Getter
    private Plateau plateau;
    @Getter
    private Couleur tour;
    @Setter
    private boolean mat;
    @Setter
    private boolean pat;
    @Setter
    private boolean check;

    public Jeu(){
        score = 0;
        Couleur tour = Couleur.BLANC;
        mat = false;
        pat = false;
        check = false;
        plateau = new Plateau();
        plateau.initialisationPlateau();
        debutPartie();
    }

    public void etatPartie(){
        if (nombreCoupsPossibles() == 0){
            if (!check) {
                pat = true;
            }
            else{
                mat = true;
            }
        }

    }

    public void testCheck(){
        Coordonnee coordRoi = trouverRoi();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Piece p = plateau.getCase(x,y).getPiece();
                if (p!=null && getTour() != p.getCouleur()) {
                    if (p.getCoupsPossibles().contains(coordRoi)){
                        setCheck(true);
                    }
                }
            }
        }
    }

    public Coordonnee trouverRoi() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Piece p = plateau.getCase(x, y).getPiece();
                if (p != null && p.getCouleur() != getTour()) {
                    if (p instanceof Roi) {
                        return new Coordonnee(x, y);
                    }
                }
            }
        }
        return null;
    }


    public void debutPartie(){
        plateau.initialisationPiece();
        calculScore();
    }

    public void calculScore(){
        int score = 0;
        Plateau plateau = getPlateau();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Piece p = plateau.getCase(x,y).getPiece();
                if (p!=null) {
                    Couleur couleur = p.getCouleur();
                    int scoreCouleur = couleur == Couleur.BLANC ? 1 : -1;
                    switch (p) {
                        case Pion pion:
                            score += scoreCouleur;
                            break;
                        case Cavalier cavalier:
                            score += 3 * scoreCouleur;
                            break;
                        case Fou fou:
                            score += 3 * scoreCouleur;
                            break;
                        case Reine dame:
                            score += 10 * scoreCouleur;
                            break;
                        case Tour tour1:
                            score += 5 * scoreCouleur;
                            break;
                        default:
                            score += 0;
                    }
                }
            }
        }
        setScore(score);
    }

    public int nombreCoupsPossibles(){
        int nbrCoups = 0;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Piece p = plateau.getCase(x,y).getPiece();
                if (p!=null && p.getCouleur() == this.tour){
                    nbrCoups += p.getCoupsPossibles().toArray().length;
                }
            }
        }
        return nbrCoups;
    }
}


