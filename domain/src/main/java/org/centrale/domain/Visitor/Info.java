package org.centrale.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Info implements Departement {
    private List<Project> projects;

    public Info() {
        this.projects = new ArrayList<>();
        this.projects.add(new Website());
        this.projects.add(new MobileApp());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Project project : projects) {
            project.accept(visitor);
        }
    }
}
