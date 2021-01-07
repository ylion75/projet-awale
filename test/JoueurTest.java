
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;

public class JoueurTest {
    @Test
    public void JoueurTest(){
        Joueur J1 = new Joueur("SUD");
        Joueur J2 = new Joueur("NORD");
        System.out.println(J1.getNom());
        System.out.println(J2.getNom());
        assertNotEquals(J1.getNumero(),J2.getNumero());
        Assert.assertEquals(J1.getNumero(),0);
        Assert.assertEquals(J2.getNumero(),1);
    }

}

