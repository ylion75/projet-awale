public class Jeu implements Regles {
    //private static PlateauJeu plateau;
    private Joueur J1;
    private Joueur J2;
    private PlateauJeu plateau;
    private boolean coupPossible;
    private boolean finDepartie;

    //On utilise le constructeur vide pour travailler sur la version de base de l'Awale
    public Jeu(){
        this.J1 = new Joueur("SUD");
        this.J2 = new Joueur("NORD");
        this.plateau = new PlateauJeu(2,6, 4);
        boolean finDePartie = false;
    }

    @Override
    public int premierJoueur(){
        //de base c'est J1 qui commence, on pourra mettre un rand sur d'autres versions du jeu
        //0 correspond au joueur 1
        return 0;
    }

    @Override
    public int joueurSuivant(int joueurActuel) {
        if(joueurActuel == 0){
            return 1;
        }
        else return 0;
    }

    @Override
    public void joueurUnCoup() {
        /*
        if(plateau.getGraineDansTrou(x,y) != 0){
            plateau[x][y]
        }

         */
    }

    @Override
    public boolean finDePartie() {
        return false;
    }


    public static void main(String[] args) {
        Jeu awale = new Jeu();
        awale.plateau.afficherPlateau();
    }

}
