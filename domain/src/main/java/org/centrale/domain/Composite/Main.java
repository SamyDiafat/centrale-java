package org.centrale.domain.Composite;



// Exemple d'utilisation
public class Main {
    public static void main(String[] args) {
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
    }
}
