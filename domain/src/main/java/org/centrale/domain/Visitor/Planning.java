package org.centrale.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Planning implements Project {

    private List<Employe> employeList;


    public Planning() {
        this.employeList = new ArrayList<>();
        this.employeList.add(new AirbusEmploye("Catherine Lalou",50000.0));
        this.employeList.add(new AirbusEmploye("Jacqueline Lairhache",55000.0));
        this.employeList.add(new AirbusEmploye("Louise Lajeune",40000.0));
        this.employeList.add(new AirbusEmploye("Alison Bout",65000.0));
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Employe employe : employeList) {
            employe.accept(visitor);
        }
    }
}

