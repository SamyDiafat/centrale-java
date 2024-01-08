package org.centrale.cli;

import org.centrale.domain.IHMSaisie;
import org.centrale.domain.Choix;

public class Joueur {

    private String nom;
    private int score;

    private IHMSaisie saisie;


    Joueur(String nom){
        this.nom = nom;
        this.score = 0;
        IHMSaisie saisie = new IHMSaisie(nom);
        this.saisie = saisie;
    }


    public void crediter(){
        this.score += 1;
    }

    public Choix choisir(){
        return saisie.proposerChoix();
    }

    public int getScore(){
        return score;
    }

    public void ecrireScore(){
        System.out.println("Le score de "+ nom + "est "+ score);
    }

    public String getNom(){
        return this.nom;
    }
}

