package org.centrale.domain.Composite;

public class SingleEmployee implements Employee {
    private String name;
    private double salary;

    public SingleEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
