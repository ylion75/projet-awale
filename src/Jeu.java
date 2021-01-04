public class Jeu implements Regles {
    private Joueur J1;
    private Joueur J2;
    private PlateauJeu plateau;
    private boolean finDepartie;

    /**
     * Le constructeur vide permet de lancer la version classique de l'Awale
     */
    public Jeu(){
        this.J1 = new Joueur("SUD");
        this.J2 = new Joueur("NORD");
        this.plateau = new PlateauJeu(2,6, 4);
        boolean finDePartie = false;
    }

    /**
     * Par défaut, c'est le Joueur 1 qui commence.
     * @return J1
     */
    @Override
    public Joueur premierJoueur(){
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
    public void jouerUnCoup(Joueur joueuractif) {

        //Décomposition en 3 sous méthodes (private)
        //choixCase();
        //egreiner();
        //ramasser();
    }

    //version qui marche pas
    /*
        private static int[] choixCase(int joueurActif, int choixUtilisateur){
        assert(choixUtilisateur >= 0 && choixUtilisateur <= 12);
        //if(!isTrouVide)
        if(joueurActif == 0)
            return new int[]{0, choixUtilisateur - 1};
        else return new int[]{1, ((choixUtilisateur - 12) * - 1)};
        //si numero joueur == 0, alors il joue dans les cases 1-6
        //si numero == 1, alors il joue dans les cases 7-12
        //choix 0 = passe le boolean finDePartie a true;
    }
     */

    private static int choixCase(int choixUtilisateur){
        int caseChoisie = 0;
        assert(choixUtilisateur >= 0 && choixUtilisateur <= 12);
        //if(!isTrouVide)
        if(choixUtilisateur > 0 && choixUtilisateur < 7){
            caseChoisie = choixUtilisateur - 1;
        System.out.println(caseChoisie);
        }
        if(choixUtilisateur > 6) {
            caseChoisie = (choixUtilisateur - 12) * (-1);
            System.out.println(caseChoisie);
        }
        return caseChoisie;
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
        int joueurAdverse;
        if(numeroJoueur == 0)
            joueurAdverse = 1;
        else joueurAdverse = 0;
        while(plateau.nbGrainerangee(joueurAdverse) > 0)
            semer(numeroJoueur, numeroTrou);
        // while pour vérifier que la ligne n'est pas vide
        //while()
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
        System.out.println();
        //System.out.println(choixCase(0,3));;
        choixCase(12);


        //System.out.println(choixCase(11));

    }

}
