public class Jeu implements Regles {
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

        //choixCase();
        //egreiner();
        //ramasser();
    }


    private void choixCase(Joueur joueurActif){
        //if(!isTrouVide)
        //si numero joueur == 0, alors il joue dans les cases 1-6
        //si numero == 1, alors il joue dans les cases 7-12
        //choix 0 = passe le boolean finDePartie a true;
    }

    /**
     *
     * @param numeroJoueur
     * @param numeroTrou
     * @return
     * Attention, on met
     */
    private int[] semer(int numeroJoueur, int numeroTrou){
        int nbGraine = plateau.getGraineDansTrou(numeroJoueur, numeroTrou);
        int caseASemer = numeroTrou;
        for(int i = nbGraine; i == 0; i--){
            plateau.ajouteUneGraine(numeroJoueur,caseASemer);
            if(numeroJoueur == 0)
                caseASemer++;
            else
                caseASemer--;

            if((caseASemer == plateau.getPlateau()[numeroJoueur].length - 1 && numeroJoueur == 0)
            ||(caseASemer == 0 && numeroJoueur == 1)){
                numeroJoueur = (numeroJoueur +1) %2;
            }
        }
        return new int[]{numeroJoueur, caseASemer};
    }

    private void ramasser(int numeroJoueur, int numeroTrou){
        // à rajouter : while pour vérifier que la ligne n'est pas vide
        // while: vérifier si la case finale contient 2 ou 3 graines + vérifier qu'elle appartient au joueur adverse
        // la case passe à 0, le nombre de graine passe au score du joueur
    }

    public boolean isTrouVide(int numeroJoueur, int numeroTrou){
        if(plateau.getGraineDansTrou(numeroJoueur,numeroTrou) == 0)
            return true;
        else return false;
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
