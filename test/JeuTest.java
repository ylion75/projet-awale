import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JeuTest {
    Jeu awale = new Jeu();

    @Test
    public void initialisationJeu() {
        Joueur[] tabjoueur = awale.getJoueurs();
        assertEquals(tabjoueur[0].getNumero(), 0);
        assertEquals(tabjoueur[1].getNumero(), 1);
        System.out.println(awale.J1.getNumero());
        System.out.println(awale.J2.getNumero());
        assertEquals(tabjoueur[0].getNom(), "SUD");
        assertEquals(tabjoueur[1].getNom(), "NORD");
        assertEquals(awale.premierJoueur().getNumero(), 0);
    }

    @Test
    public void semerTest() {
        int[] semerTest = awale.semer(0, 3);
        //a changé de camp donc normalement camp d'en face
        assertEquals(semerTest[0], 1);
        assertEquals(semerTest[1], 4);
        assertEquals(awale.plateau.getGraineDansTrou(0,3), 0);

        int[] semerTest2 = awale.semer(1, 2);
        //a changé de camp donc normalement camp d'en face
        assertEquals(semerTest2[0], 0);
        assertEquals(semerTest2[1], 1);
        assertEquals(awale.plateau.getGraineDansTrou(1,2),0);
    }


    @Test
    public void ramasserGraineTest(){
        //Jeu awale = new Jeu();
        //ramasserGraine(0,2, )
    }


    @Test
    public void jouerUnCoupTest(){

        System.out.println(awale.J1.getNumero());
        System.out.println(awale.J2.getNumero());
        /*
        awale.jouerUnCoup(awale.J1, awale.convertisseurLigne(4, awale.J1));
        assertEquals(awale.plateau.getGraineDansTrou(1,3),4);
        awale.jouerUnCoup(awale.J2, awale.convertisseurLigne(9, awale.J2));
        awale.jouerUnCoup(awale.J1, awale.convertisseurLigne(1, awale.J1));

        awale.jouerUnCoup(awale.J2, awale.convertisseurLigne(7, awale.J2));
        awale.jouerUnCoup(awale.J1, awale.convertisseurLigne(5, awale.J1));

        awale.jouerUnCoup(awale.J2, awale.convertisseurLigne(7, awale.J2));
        awale.jouerUnCoup(awale.J1, awale.convertisseurLigne(3, awale.J1));
        awale.jouerUnCoup(awale.J2, awale.convertisseurLigne(8, awale.J2));

        //J2 joue en

        //vérifie qu'il joue dans la bonne case et qu'il sème bien dans la suivante
        //assertEquals(awale.plateau.getGraineDansTrou(0,4), 0);

         */


    }









    /*
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

     */
}






