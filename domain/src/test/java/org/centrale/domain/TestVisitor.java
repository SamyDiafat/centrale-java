package org.centrale.domain;

import org.centrale.domain.PierreFeuilleCiseaux.Pierre;
import org.centrale.domain.Visitor.Airbus;
import org.centrale.domain.Visitor.Departement;
import org.centrale.domain.Visitor.Entreprise;
import org.centrale.domain.Visitor.VisiteurQuiCalculSalaire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestVisitor {


    @Test
    public void test(){
        VisiteurQuiCalculSalaire visitor = new VisiteurQuiCalculSalaire();

        Entreprise airbus = new Airbus();

        List<Double> listeSalaires = new ArrayList<>();
        listeSalaires.add(65000.0);
        listeSalaires.add(100000.0);
        listeSalaires.add(70000.0);
        listeSalaires.add(35000.0);
        listeSalaires.add(50000.0);
        listeSalaires.add(55000.0);
        listeSalaires.add(40000.0);
        listeSalaires.add(65000.0);

        airbus.accept(visitor);

        Assertions.assertEquals(visitor.getNbEmploye(), 8);
        Assertions.assertEquals(visitor.getListeSalaire(),listeSalaires);
    }
}
