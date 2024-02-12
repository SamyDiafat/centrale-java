package org.centrale.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

public class MobileApp implements Project{




    private List<Employe> employeList;

    public MobileApp() {
        this.employeList = new ArrayList<>();

        this.employeList.add(new AirbusEmploye("Michel Info",70000.0));
        this.employeList.add(new AirbusEmploye("Didier Computer",35000.0));
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Employe employe : employeList) {
            employe.accept(visitor);
        }
    }
}
