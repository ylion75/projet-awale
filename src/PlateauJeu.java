import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Arrays.*;
import java.io.*;

public class PlateauJeu {
    private int rangee; //correspond à une colonne
    private int trou; //correspond à une case (ligne)
    private int graineParTrou;
    private int[][] plateau;


    public PlateauJeu(int rangee, int trou){
        //les données sont mises en dur pour l'instant
        this.rangee = rangee;
        this.trou = trou;
        this.graineParTrou = 4;
        this.plateau  = new int[rangee][trou];
        for (int i = 0;i < this.plateau.length; i++) {
            for (int j = 0;j < this.plateau[i].length;j++) {
                this.plateau[i][j] = this.graineParTrou;
            }
        }
    }

    public PlateauJeu(){
        this.rangee = 2;
        this.trou = 6;
        this.graineParTrou = 4;
    }

    //pb avec toString parce qu'il faut convertir le tableau en String
    //pour l'affichage

    public void afficherPlateau() {
        for (int i = this.rangee * this.trou; i > this.trou; i--){
            System.out.print("  " + i + "  ");
        }
        System.out.println(); //saut de ligne

        for (int[] ints : plateau) {
            for (int anInt : ints) {
                System.out.print("[ " + anInt + " ] ");

            }
            System.out.println();
        }
    }
}



