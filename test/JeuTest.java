import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JeuTest {

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

    /*
    @Test
    public void choixCaseTest() {
        Jeu awale = new Jeu();
        int choixCaseTest = awale.choixCase(11);
        int choixCaseTest2 = awale.choixCase(6);
        int choixCaseTestFinPartie = awale.choixCase(0);
        //vérifie que choixCase() renvoie au bon indice selon la saisie de l'utilisateur
        //et que le booleen finDePartie passe true lorsqu'il saisit 0
        assertEquals(choixCaseTest, 1);
        assertEquals(choixCaseTest2, 5);
        assertEquals(choixCaseTestFinPartie, -1);
        assertEquals(awale.getFinDePartie(), true);
    }

     */

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
    public void convertisseurLigneTest(){
        Jeu awale = new Jeu();
        int convertisseurLignetest1 = awale.convertisseurLigne(1, awale.J1);
        int convertisseurLignetest2 = awale.convertisseurLigne(2, awale.J1);
        int convertisseurLignetest3 = awale.convertisseurLigne(3, awale.J1);
        int convertisseurLignetest4 = awale.convertisseurLigne(4, awale.J1);
        int convertisseurLignetest5 = awale.convertisseurLigne(5, awale.J1);
        int convertisseurLignetest6 = awale.convertisseurLigne(6, awale.J1);
        assertEquals(convertisseurLignetest1, 0);
        assertEquals(convertisseurLignetest2, 1);
        assertEquals(convertisseurLignetest3, 2);
        assertEquals(convertisseurLignetest4, 3);
        assertEquals(convertisseurLignetest5, 4);
        assertEquals(convertisseurLignetest6, 5);

        int convertisseurLignetest7 = awale.convertisseurLigne(7, awale.J2);
        int convertisseurLignetest8 = awale.convertisseurLigne(8, awale.J2);
        int convertisseurLignetest9 = awale.convertisseurLigne(9, awale.J2);
        int convertisseurLignetest10 = awale.convertisseurLigne(10, awale.J2);
        int convertisseurLignetest11 = awale.convertisseurLigne(11, awale.J2);
        int convertisseurLignetest12 = awale.convertisseurLigne(12, awale.J2);
        assertEquals(convertisseurLignetest1, 0);
        assertEquals(convertisseurLignetest2, 1);
        assertEquals(convertisseurLignetest3, 2);
        assertEquals(convertisseurLignetest4, 3);
        assertEquals(convertisseurLignetest5, 4);
        assertEquals(convertisseurLignetest6, 5);
    }



    @Test
    public void ramasserTest() {
        Jeu awale = new Jeu();


        //awale.ramasser(0, 1,awale.J1);


        //PlateauJeu.awale.setGraineDansTrou(0,1,3);

        //awale.ramasser(0,1);
        //assertEquals(plateau.getGraineDansTrou(0,1),3);


    }
}






