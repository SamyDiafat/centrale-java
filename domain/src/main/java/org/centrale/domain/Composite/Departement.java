package org.centrale.domain.Composite;

import java.util.ArrayList;
import java.util.List;

public class Departement implements Employee {
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Departement(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }
}

