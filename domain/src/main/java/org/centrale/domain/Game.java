package org.centrale.domain;

public class Game {

    public Joueur joueur1;
    public Joueur joueur2;

    public Joueur winner;

    public Game(String nom1, String nom2){
        this.joueur1 = new Joueur(nom1);
        this.joueur2 =new Joueur(nom2);
        jouer();
    }

    public void jouer(){
        System.out.println("Le score du joueur " +joueur1.getNom()+ " est " + joueur1.getScore());
        System.out.println("Le score du joueur " + joueur2.getNom() + " est " + joueur2.getScore());
        System.out.println("Lancement de la partie");
        tour();
        conclure();
        get_winner();
    }

    public Joueur get_winner() {
        return winner;
    }

    public void tour(){
        String mainJoueur1 = joueur1.jouerTourAleatoirement();
        Hand main1 = HandFactory.from(mainJoueur1);
        System.out.println(joueur1.getNom() + " a joué "+ mainJoueur1);
        String mainJoueur2 = joueur2.jouerTourAleatoirement();
        Hand main2 = HandFactory.from(mainJoueur2);
        System.out.println(joueur2.getNom() + " a joué "+mainJoueur2);
        joueur1.ecrireScore(main2.playWith(main1));
        joueur2.ecrireScore(main1.playWith(main2));
    }



    public void conclure() {
        System.out.println("Le score du joueur " +joueur1.getNom()+ " est " + joueur1.getScore());
        System.out.println("Le score du joueur " + joueur2.getNom() + " est " + joueur2.getScore());
        if (joueur1.getScore() > joueur2.getScore()) {
            System.out.println("Victoire finale de " + joueur1.getNom());
            winner = joueur1;
        } else {
            if (joueur1.getScore() == joueur2.getScore()){
                System.out.println("Egalité");
                winner = joueur2;// A revoir
            } else{
                System.out.println("Victoire final de " + joueur2.getNom());
                winner = joueur2;
            }
        }

    }
}
