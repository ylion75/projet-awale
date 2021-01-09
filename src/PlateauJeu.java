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

    /**
     * L'initialisation avec le constructeur vide lance la version de base de l'Awalé
     */
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

    public int getTrou() {
        return trou;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public int getRangee() {
        return rangee;
    }

    public int getGraineDansTrou(int numeroJoueur, int numeroTrou){
        return plateau[numeroJoueur][numeroTrou];
    }

    /**
     * Permet de calculer le nombre de graine dans une rangée.
     * @param numeroJoueur 0 correspond à J1 et 1 à J2
     * @return
     */
    public int getNBGrainerangee(int numeroJoueur){
        int cptGraine = 0;
        for(int j = 0; j < trou; j++)
            cptGraine += plateau[numeroJoueur][j];
        return cptGraine;
    }

    public int getNBGrainesRestantes(){
        int nbGrainesTotal = 0;
        for(int[] ligne : this.plateau){
            for(int trou : ligne){
                nbGrainesTotal += trou;
            }
        }
        return nbGrainesTotal;
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
            for(int l = rangee -1; l >= 0; l--){
                int[] ints = plateau[l];
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
    }

    public static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
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
     * Permet de donner la case suivante
     * Passe dans la partie adverse du plateau lorsqu'on arrive en bout de ligne
     * @param numeroJoueur
     * @param numeroTrou
     * @return les coordonnées correspondant à la case suivante
     */
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
}




