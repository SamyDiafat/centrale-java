package org.centrale.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class HR implements Departement {
    private List<Project> projects;

    public HR() {
        this.projects = new ArrayList<>();
        this.projects.add(new Planning());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Project project : projects) {
            project.accept(visitor);
        }
    }
}
