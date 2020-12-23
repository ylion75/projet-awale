import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JeuTest {
    @Test
    public void premierJoueurTest(){
        Jeu awale = new Jeu();
        assertEquals(awale.premierJoueur(), 0);
    }

    @Test
    public void joueurSuivantTest(){
        Jeu awale = new Jeu();
        assertEquals(awale.joueurSuivant(1),0);
        assertEquals(awale.joueurSuivant(0),1);
    }
}
