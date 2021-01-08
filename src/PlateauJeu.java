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

    public int[] caseSuivante(int numeroJoueur, int numeroTrou){
        //on change de joueur en arrivant au bout de plateau
        if((numeroTrou == getPlateau()[numeroJoueur].length - 1 && numeroJoueur == 0)
                ||(numeroTrou == 0 && numeroJoueur == 1)){
            numeroJoueur = (numeroJoueur +1) %2;
        }
        else if(numeroJoueur == 0)
            numeroTrou++;
        else if(numeroJoueur == 1)
            numeroTrou --;
        return new int[]{numeroJoueur, numeroTrou};
    }

    public int[] casePrecedente(int numeroJoueur, int numeroTrou){
        //on change de joueur en arrivant au bout de plateau
        if((numeroTrou == getPlateau()[numeroJoueur].length - 1 && numeroJoueur == 1)
                ||(numeroTrou == 0 && numeroJoueur == 0)){
            numeroJoueur = (numeroJoueur +1) %2;
        }
        else if(numeroJoueur == 1)
            numeroTrou++;
        else if(numeroJoueur == 0)
            numeroTrou--;
        return new int[]{numeroJoueur, numeroTrou};
    }

    public void afficherPlateau() {
        int cpt = 0;
        clearScreen();
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
        System.out.println("Nord a " + nbGrainerangee(1) + " graine(s)" ); //reflechir à une var graineLigne
        System.out.println("Sud a " + nbGrainerangee(0) + " graine(s)");
    }

    public static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }


    
    public int getGraineDansTrou(int numeroJoueur, int numeroTrou){
        return plateau[numeroJoueur][numeroTrou];
    }


    public void viderLeTrou(int numeroJoueur, int numeroTrou){
        plateau[numeroJoueur][numeroTrou] = 0;
    }

    /**
     * Pour essaimer les graines dans les trous suivants
     * @param numeroJoueur
     * @param numeroTrou
     */
    public void ajouteUneGraine(int numeroJoueur, int numeroTrou){
        plateau[numeroJoueur][numeroTrou]++;
    }

    /**
     * Permet de calculer le nombre de graine dans une rangée.
     * @param numeroJoueur 0 correspond à J1 et 1 à J2
     * @return
     */
    public int nbGrainerangee(int numeroJoueur){
        int cptGraine = 0;
        for(int j = 0; j < trou; j++)
            cptGraine += plateau[numeroJoueur][j];
        return cptGraine;
    }

    public int nbGrainesRestantes(){
        int nbGrainesTotal = 0;
        for(int[] ligne : this.plateau){
            for(int trou : ligne){
                nbGrainesTotal += trou;
            }
        }
        return nbGrainesTotal;
    }

    public int getTrou() {
        return trou;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    //getter pour les tests
    public int getRangee() {
        return rangee;
    }

    //fonction pour test unitaire
    public void setGraineDansTrou(int numeroJoueur, int numeroTrou, int nbGraine){
        assert (numeroJoueur >= 0 && numeroJoueur <= 1 && numeroTrou >= 0 && numeroTrou <= 5);
        plateau[numeroJoueur][numeroTrou] = nbGraine;
    }
}




