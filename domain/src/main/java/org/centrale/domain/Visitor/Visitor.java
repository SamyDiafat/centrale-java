package org.centrale.domain.Visitor;

public interface Visitor {
    void visit(Entreprise entreprise);
    void visit(Departement departement);
    void visit(Project project);
    void visit(Employe employee);
}
