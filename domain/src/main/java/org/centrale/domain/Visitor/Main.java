package org.centrale.domain.Visitor;


public class Main {
    public static void main(String[] args){
        //Initialisation du visiteur
        VisiteurQuiCalculSalaire visitor = new VisiteurQuiCalculSalaire();

        Entreprise airbus = new Airbus();
        airbus.accept(visitor);

        System.out.println("le nombre d'employe de l'entreprise est " +visitor.getNbEmploye());
        System.out.println("les salaires du service informatique sont " + visitor.getListeSalaire());

    }
}
