package org.centrale.domain.Visitor;

public class AirbusEmploye implements Employe {
    private String name;

    private Double salaire;


    public AirbusEmploye(String name, Double salaire) {
        this.name = name;
        this.salaire = salaire;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    @Override
    public String getName() {
        return name;
    }


    @Override
    public Double getSalaire(){
        return salaire;
    }
}