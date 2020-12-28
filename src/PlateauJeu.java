import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Arrays.*;
import java.io.*;

public class PlateauJeu {
    private int rangee; //correspond à une colonne
    private int trou; //correspond à une case (ligne)
    private int graineParTrou;
    private int[][] plateau;


    public PlateauJeu(int rangee, int trou, int graineParTrou) {
        this.rangee = rangee;
        this.trou = trou;
        this.graineParTrou = graineParTrou;

        this.plateau = new int[rangee][trou];
        for (int row = 0; row < this.plateau.length; row++) {
            for (int col = 0; col < this.plateau[row].length; col++) {  //Intellij sugere Arrays.fill(this.plateau[i], this.graineParTrou);
                this.plateau[row][col] = this.graineParTrou;
            }
        }
    }

    //version avec constructeur vide charge l'Awale de base.
    //le code est dupliqué y'a peut être moyen de faire qqchose pour enlever un des deux
    public PlateauJeu() {
        this.rangee = 2;
        this.trou = 6;
        this.graineParTrou = 4;

        this.plateau = new int[rangee][trou];
        for (int row = 0; row < this.plateau.length; row++) {
            for (int col = 0; col < this.plateau[row].length; col++) {  //Intellij sugere Arrays.fill(this.plateau[i], this.graineParTrou);
                this.plateau[row][col] = this.graineParTrou;
            }
        }
    }

    public void setGraineParTrou(int graineParTrou) {
        this.graineParTrou = graineParTrou;
    }

    public void afficherPlateau() {
        int cpt = 0;
        System.out.print("NORD");
        for (int i = this.rangee * this.trou; i > this.trou; i--) { // NORD
            if (i >= 10) { //Permet d'augmenter l'espace quand un chiffre contient moins de deux nombres
                System.out.print("  " + i + "  ");
            } else {
                System.out.print("  " + i + "   ");
            }
        }
        System.out.println(); //saut de ligne
        System.out.print("    ");
            for (int[] ints : plateau) {
                for (int anInt : ints) {
                    System.out.print("[ " + anInt + " ] ");
                    cpt ++;
                }
                if (cpt == 6) {    // condition qui permet de dire qu'au 6e [4] faire un saut de ligne plus espace
                    System.out.println();    //sans ça SUD était décallé au niveau du premier 4
                    System.out.print("    ");
                }
                else{
                    System.out.println();
                }
            }
        System.out.print("SUD ");
            for (int j = 1; j <= this.trou; j++) { //Ligne SUD
                System.out.print("  " + j + "   ");
            }
        System.out.println(); //saut de ligne
        System.out.println("Nord a " ); //reflechir à une var graineLigne
        System.out.println("Sud a " );

        System.out.println("Au joueur " );//+ getNom())
    }
    
    public int getGraineDansTrou(int x, int y){
        return plateau[x][y];
    }

    public void ajouteUneGraine(int x, int y){
        plateau[x][y]++;
    }

    //calcule le nombre de graine par rangée
    // numeroJoueur est soit 0 (NORD) soit 1 (SUD)
    public int nbGrainerangee(int numeroJoueur){
        int cptGraine = 0;
        for(int j = 0; j < trou; j++)
            cptGraine += plateau[numeroJoueur][j];
        return cptGraine;
    }

    //getter pour les tests
    public int getRangee() {
        return rangee;
    }

    public int getTrou() {
        return trou;
    }
}




