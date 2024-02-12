package org.centrale.domain;

import java.util.Random;

public class Joueur {

    private String nom;
    private int score;



    Joueur(String nom){
        this.nom = nom;
        this.score = 0;
    }


    public void crediter(){
        this.score += 1;
    }


    public int getScore(){
        return score;
    }

    public void ecrireScore(int point){
        this.score += point;
    }

    public String getNom(){
        return this.nom;
    }

    public String jouerTourAleatoirement(){
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch(randomNumber){
            case 0 :
                return "Feuille";
            case 1:
                return "Pierre";
            case 2 :
                return "Ciseaux";
        }
        return "Pierre";
    }
}

