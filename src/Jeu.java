public class Jeu implements Regles {
    //private static PlateauJeu plateau;
    private Joueur J1;
    private Joueur J2;
    private PlateauJeu plateau;
    private boolean finDepartie;

    //On utilise le constructeur vide pour travailler sur la version de base de l'Awale
    public Jeu(){
        this.J1 = new Joueur("SUD");
        this.J2 = new Joueur("NORD");
        this.plateau = new PlateauJeu(2,6, 4);
        boolean finDePartie = false;
    }

    @Override
    public Joueur premierJoueur(){
        //de base c'est J1 qui commence, on pourra mettre un rand sur d'autres versions du jeu
        //0 correspond au joueur 1
        return J1;
    }

    @Override
    public Joueur joueurSuivant(Joueur joueurActuel) {
        if(joueurActuel == J1){
            return J1;
        }
        else return J2;
    }

    @Override
    public void jouerUnCoup() {
        //si J1 (SUD) :
        // joue 1 à 6
        // tab[1][], séme vers la droite dans son côté
        //si J2(NORD)
        //joue 7 à 12
        //sème vers la gauche de son côté
        /*
        if(plateau.getGraineDansTrou(x,y) != 0){
            plateau[x][y]
        }
        //boolean sens ? 

         */
    }

    public boolean isTrouVide(int x, int y){
        if(plateau.getGraineDansTrou(x,y) == 0)
            return true;
        else return false;
    }

    public void prendGraineAGauche(int x, int y, int positionTrou){
        
    }

    @Override
    public boolean finDePartie() {
        return false;
    }

    public Joueur[] getJoueurs() {
        return new Joueur[]{J1, J2};
    }

    public static void main(String[] args) {
        Jeu awale = new Jeu();
        awale.plateau.afficherPlateau();
        System.out.println(awale.plateau.getGraineDansTrou(1,1));
        awale.plateau.ajouteUneGraine(1,1);
        System.out.println(awale.plateau.getGraineDansTrou(1,1));
        System.out.println(awale.plateau.getGraineDansTrou(0,1));
    }

}
