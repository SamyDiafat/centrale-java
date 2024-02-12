package org.centrale.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Airbus implements Entreprise {
    private List<Departement> departements;

    public Airbus() {
        this.departements = new ArrayList<>();
        this.departements.add(new Info());
        this.departements.add(new HR());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Departement departement : departements) {
            departement.accept(visitor);
        }
    }

    public List<Departement> getDepartements() {
        return departements;
    }
}
