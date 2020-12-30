import org.junit.Test;

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


}
