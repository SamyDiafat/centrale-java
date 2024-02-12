package org.centrale.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPierreFeuilleCiseaux {

    @Test 
    public void jeuEgalite(){
        IHMSaisie saisie = new IHMSaisie("Samy");
        Choix choix = saisie.proposerChoix();
        Choix choix_test = Choix.CAILLOU;
        Assertions.assertEquals(saisie.getName(), "Samy");
    }

}
