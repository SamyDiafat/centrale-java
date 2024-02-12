package org.centrale.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisiteurQuiCalculSalaire implements Visitor {

    private Integer compteurEmploye;
    private List<Double> listeSalaire = new ArrayList<>();

    public VisiteurQuiCalculSalaire(){
        this.compteurEmploye = 0;
    }
    @Override
    public void visit(Entreprise entreprise) {
        System.out.println("Je Visite Entreprise mais je ne fais rien");
    }

    @Override
    public void visit(Departement departement) {
        System.out.println("Visiting Departement mais je ne fais rien");
    }

    @Override
    public void visit(Project project) {
        System.out.println("Je Visite Project mais je ne fais rien");
    }

    @Override
    public void visit(Employe employee) {
        System.out.println("Je Visite Employe : " + employee.getName() + " son salaire est " + employee.getSalaire());
        compteurEmploye+=1;
        listeSalaire.add(employee.getSalaire());
    }

    public Integer getNbEmploye() {
        return compteurEmploye;
    }

    public List<Double> getListeSalaire(){
        return listeSalaire;
    }

}
