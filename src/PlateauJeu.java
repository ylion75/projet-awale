import java.util.Arrays;
import java.util.Arrays.*;
import java.io.*;

public class PlateauJeu {
    private int rangee;
    private int trou; //correspond à une case
    private int graineParTrou;
    private int[][] plateau;

    public PlateauJeu(int rangee, int trou){
        //les données sont mises en dur pour l'instant
        this.rangee = rangee;
        this.trou = trou;
        this.graineParTrou = 4;
        plateau  = new int[rangee][trou];
        for (int i = 0;i < plateau.length; i++) {
            for (int j = 0;j < plateau[i].length;j++) {
                plateau[i][j] = graineParTrou;
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public PlateauJeu(){
        this.rangee = 2;
        this.trou = 6;
        this.graineParTrou = 4;
    }

    //pb avec toString parce qu'il faut convertir le tableau en String
    //pour l'affichage
    /*
    @Override
    public String toString() {
        return;


    }

     */


}



