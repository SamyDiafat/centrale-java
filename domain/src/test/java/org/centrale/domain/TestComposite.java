package org.centrale.domain;

import org.centrale.domain.Composite.Departement;
import org.centrale.domain.Composite.SingleEmployee;
import org.centrale.domain.PierreFeuilleCiseaux.Pierre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComposite {

    @Test
    public void test() {


        Departement engineering = new Departement("Engineering");
        engineering.addEmployee(new SingleEmployee("Samy", 7000));
        engineering.addEmployee(new SingleEmployee("Lucas", 6000));

        Departement sales = new Departement("Sales");
        sales.addEmployee(new SingleEmployee("Michou", 4500));
        sales.addEmployee(new SingleEmployee("Didier", 5500));

        Departement hr = new Departement("HR");
        hr.addEmployee(engineering);
        hr.addEmployee(sales);

        hr.showDetails();
        System.out.println("Total Salary: " + hr.calculateSalary());

        Assertions.assertEquals(hr.calculateSalary(), 23000.0);
    }
}
