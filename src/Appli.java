import java.util.Arrays;

public class Appli {
    public static void main(String[] args) {
        //Sans paramètre, il lance l'awalé de base.
        PlateauJeu awalé2 = new PlateauJeu();
        //System.out.println(awalé2.toString());

        //version custom, pour les autres versions du jeu
        PlateauJeu awalé = new PlateauJeu(2, 6);
        //System.out.println(awalé.toString());

    }
}
