import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JeuTest {
    /*
    //private Jeu awale;

    //initialisation hors des jeux de tests parce que le numéro de Joueur est déclaré static
    public JeuTest() {
        this.awale = new Jeu();
    }

     */

    @Test
    public void initialisationJeu() {
        Jeu awale = new Jeu();
        Joueur[] tabjoueur = awale.getJoueurs();
        assertEquals(tabjoueur[0].getNumero(), 0);
        assertEquals(tabjoueur[1].getNumero(), 1);
        assertEquals(tabjoueur[0].getNom(), "SUD");
        assertEquals(tabjoueur[1].getNom(), "NORD");
        assertEquals(awale.premierJoueur().getNumero(), 0);
    }


    @Test
    public void choixCaseTest() {
        Jeu awale = new Jeu();
        int choixCaseTest = awale.choixCase(11);
        int choixCaseTest2 = awale.choixCase(6);
        int choixCaseTestFinPartie = awale.choixCase(0);
        assertEquals(choixCaseTest, 1);
        assertEquals(choixCaseTest2, 5);
        assertEquals(choixCaseTestFinPartie, -1);
        assertEquals(awale.getFinDePartie(), true);
    }

    @Test
    public void semerTest() {
        Jeu awale = new Jeu();
        int[] semerTest = awale.semer(0, 3);
        //a changé de camp donc normalement camp d'en face
        assertEquals(semerTest[0], 1);
        assertEquals(semerTest[1], 4);

        int[] semerTest2 = awale.semer(1, 2);
        //a changé de camp donc normalement camp d'en face
        assertEquals(semerTest2[0], 0);
        assertEquals(semerTest2[1], 1);

    }


    @Test
    public void ramasserTest() {
        Jeu awale = new Jeu();
        awale.getJoueurs();

        //awale.ramasser(0, 1,awale.J1);


        //PlateauJeu.awale.setGraineDansTrou(0,1,3);

        //awale.ramasser(0,1);
        //assertEquals(plateau.getGraineDansTrou(0,1),3);


    }
}






