package org.centrale.domain.Visitor;

public interface Employe {
    void accept(Visitor visitor);

    public String getName();


    public Double getSalaire();
}
