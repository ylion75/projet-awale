import org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlateauJeuTest {
    @Test
    public void PlateauJeuTest(){
        PlateauJeu p = new PlateauJeu(3,5, 8);
        assertEquals(p.getRangee(), 3);
        assertEquals(p.getTrou(),5);
        assertEquals(p.getGraineDansTrou(1,1),8);

        PlateauJeu p2 = new PlateauJeu();
        assertEquals(p2.getRangee(), 2);
        assertEquals(p2.getTrou(), 6);
        assertEquals(p2.getGraineDansTrou(1,1),4);
    }


}
