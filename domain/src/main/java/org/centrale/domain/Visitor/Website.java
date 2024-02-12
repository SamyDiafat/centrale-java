package org.centrale.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Website implements Project{



    private List<Employe> employeList;

    public Website() {
        this.employeList = new ArrayList<>();

        this.employeList.add(new AirbusEmploye("Jean Ecran",65000.0));
        this.employeList.add(new AirbusEmploye("René LaSouris",100000.0));
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Employe employe : employeList) {
            employe.accept(visitor);
        }
    }
}
