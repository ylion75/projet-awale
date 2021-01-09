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

    @Test
    public void setGraineDansTrouTest(){
        PlateauJeu p = new PlateauJeu();
        p.ajouteUneGraine(1,1);
        assertEquals(p.getGraineDansTrou(1,1),5);
    }

    @Test
    public void caseSuivanteTest(){
        PlateauJeu plateau = new PlateauJeu();
        //test du passage du changement en bout de ligne en bas
        int[] caseSuivanteBoutDeLigneBas = plateau.caseSuivante(0,5);
        assertEquals(caseSuivanteBoutDeLigneBas[0],1);
        assertEquals(caseSuivanteBoutDeLigneBas[1], 5);

        //test en bout de ligne du haut
        int[] caseSuivanteBoutDeLigneHaut = plateau.caseSuivante(1,0);
        assertEquals(caseSuivanteBoutDeLigneHaut[0],0);
        assertEquals(caseSuivanteBoutDeLigneHaut[1],0);
    }
}
