import java.util.Arrays;
import java.io.*;

public class PlateauJeu {
    private int rangee;
    private int trou; //correspond à une case
    private int graine;
    private int[][] plateau;

    public PlateauJeu(int rangee, int trou){
        //les données sont mises en dur pour l'instant
        this.rangee = rangee;
        this.trou = trou;

        plateau  = new int[rangee][trou];
        for (int i = 0;i < plateau.length; i++) {
            for (int j = 0;j < plateau[i].length;j++) {
                plateau[i][j] = 4;
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }


    /*
    public void init(){
        plateau  = new int[2][6];
        for (int i = 0;i < plateau.length; i++) {
            for (int j = 0;j < plateau[i].length;j++) {
                plateau[i][j] = 4;
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

     */
}



    //public static int

    //a faire:
    //afficher grille

