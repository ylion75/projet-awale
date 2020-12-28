import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JeuTest {
    @Test
    public void premierJoueurTest(){
        Jeu awale = new Jeu();
        assertEquals(awale.premierJoueur(), 0);
    }

    /*
    @Test
    public void joueurSuivantTest(Joueur joueurActuel){
        Jeu awale = new Jeu();
        assertEquals(awale.joueurSuivant(J1),0);
        assertEquals(awale.joueurSuivant(J2),1);
    }

     */
}
