import org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlateauJeuTest {
    @Test
    public void PlateauJeuTest(){
        PlateauJeu p = new PlateauJeu(2,6);
        assertEquals(p.getRangee(), 2);
        assertEquals(p.getTrou(),6);
    }

    @Test
    public void getGraineDansTrouTest(){
        PlateauJeu p = new PlateauJeu(2,2);
        assertEquals(p.getGraineDansTrou(2,2), 4);
    }
}
