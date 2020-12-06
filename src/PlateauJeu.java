import java.util.Arrays;

public class PlateauJeu {
    private int rangee;
    private int trou; //correspond à une case
    private int graine;
    private int[][] plateau;

    public PlateauJeu(){
        //les données sont mises en dur pour l'instant
        this.rangee = 2;
        this.trou = 6;
        this.graine = 24;
    }

    public void init(){
        plateau p  = new PlateauJeu[2][6];
        for (int i = 0;i < plateau.length; i++) {
            for (int j = 0;j < plateau[i].length;j++) {
                plateau[i][j] = 4;
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



    //public static int

    //a faire:
    //afficher grille
}
