import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;

public class JeuTest {
    private Jeu awale;

    //initialisation hors des jeux de tests parce que le numéro de Joueur est déclaré static
    public JeuTest(){
        this.awale = new Jeu();
    }

    @Test
    public void initialisationJeu(){
        Joueur[] tabjoueur = awale.getJoueurs();
        assertEquals(tabjoueur[0].getNumero(), 0);
        assertEquals(tabjoueur[1].getNumero(), 1);
        assertEquals(tabjoueur[0].getNom(), "SUD");
        assertEquals(tabjoueur[1].getNom(), "NORD");
        assertEquals(awale.premierJoueur().getNumero(), 0);
    }

    /*
    @Test
    public int[] choixCaseTest(int i, int i1){
        choixCaseTest = int[]choixCase(0,3);
        assertEquals(choixCaseTest(1,3), choixCase);
    }

     */




}
