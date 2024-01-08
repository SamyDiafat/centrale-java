package org.centrale.cli;


import org.centrale.domain.Choix;

public class JeuMultiTours {

    private Joueur joueur1;
    private Joueur joueur2;

    private boolean gameFinished;


    JeuMultiTours(String nom1, String nom2){
        Joueur joueur1 = new Joueur(nom1);
        Joueur joueur2 = new Joueur(nom2);
        this.joueur1 =joueur1;
        this.joueur2 =joueur2;
        jouer();
    }

    public void jouer(){
        System.out.println("Le score du joueur " +joueur1.getNom()+ " est " + joueur1.getScore());
        System.out.println("Le score du joueur " + joueur2.getNom() + " est " + joueur2.getScore());
        System.out.println("Lancement de la partie");
        this.gameFinished = false;
        while (!gameFinished){
            tour();
            checkgame();
        }
        conclure();
    }

    public void tour(){
        Choix choix_joueur1 = joueur1.choisir();
        Choix choix_joueur2 = joueur2.choisir();
        if ((choix_joueur2 == choix_joueur1)){
            System.out.println("Egalité");
        }else{
            if((choix_joueur1 == Choix.PAPIER) && (choix_joueur2 == Choix.CAILLOU)){
                joueur1.crediter();
                System.out.println("Victoire de " + joueur1.getNom());
            }
            if((choix_joueur1 == Choix.PAPIER) && (choix_joueur2 == Choix.CISEAU)){
                joueur2.crediter();
                System.out.println("Victoire de " + joueur2.getNom());
            }
            if((choix_joueur1 == Choix.CAILLOU) && (choix_joueur2 == Choix.CISEAU)){
                joueur1.crediter();
                System.out.println("Victoire de " + joueur1.getNom());
            }
            if((choix_joueur1 == Choix.CAILLOU) && (choix_joueur2 == Choix.PAPIER)){
                joueur2.crediter();
                System.out.println("Victoire de " + joueur2.getNom());
            }
            if((choix_joueur1 == Choix.CISEAU) && (choix_joueur2 == Choix.CAILLOU)){
                joueur2.crediter();
                System.out.println("Victoire de " + joueur2.getNom());
            }
            if((choix_joueur1 == Choix.CISEAU) && (choix_joueur2 == Choix.PAPIER)){
                joueur1.crediter();
                System.out.println("Victoire de " + joueur2.getNom());
            }
        }
    }


    public void conclure() {
        if (joueur1.getScore() > joueur2.getScore()) {
            System.out.println("Victoire finale de " + joueur1.getNom());
        } else {
            if (joueur1.getScore() == joueur2.getScore()){
                System.out.println("Egalité");
            } else{
                System.out.println("Victoire finale de " + joueur2.getNom());
            }
        }

    }

    public void checkgame(){
        if ((joueur1.getScore() == 3) || (joueur2.getScore() == 3)){
            this.gameFinished = true;
        }
    }

}
