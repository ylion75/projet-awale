import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JeuTest {
    private Jeu awale;

    public JeuTest(){
        this.awale = new Jeu();
    }

    @Test
    public void joueurSuivantTest(){
        //Jeu awale = new Jeu();
        Joueur[] tabjoueur = awale.getJoueurs();
        assertEquals(tabjoueur[0].getNumero(), 0);
        assertEquals(tabjoueur[1].getNumero(), 1);
    }


}
