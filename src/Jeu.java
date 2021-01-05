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

    public boolean getFinDePartie(){
        return finDepartie;
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
            //controle a faire : si la case n'est pas possible, lui redemander
            //lorsqu'il y a 0 graine ou que la case ne lui appartient pas
        //semer();
            //reinitialise la case choisie à 0 et renvoie int[] avec emplacement de la dernière case
        //ramasser();
            //regarde la dernière case
            //checker si elle contient 2 ou 3 graines
                //si c'est le cas, on regarde la case précédente -> on ramasse while c'est de du côté adverse et qu'il y a
                // 2 ou 3 graines
    }

    //methode repassé en public pour les tests unitaires
    public int choixCase(int choixUtilisateur){
        int caseChoisie = 0;
        assert(choixUtilisateur >= 0 && choixUtilisateur <= 12);
        //if(!isTrouVide)
        if(choixUtilisateur > 0 && choixUtilisateur < 7){
            caseChoisie = choixUtilisateur - 1;
        System.out.println(caseChoisie);
        }
        else if(choixUtilisateur > 6) {
            caseChoisie = (choixUtilisateur - 12) * (-1);
            System.out.println(caseChoisie);
        }
        else if(choixUtilisateur == 0){
            finDepartie = true;
            return -1;
        }
        return caseChoisie;
    }


    /**
     *
     * @param numeroJoueur
     * @param numeroTrou
     * @return
     * Attention, on met
     * Egalement a repasser en public
     * On travaille avec les indices du tableau
     */
    public int[] semer(int numeroJoueur, int numeroTrou){
        int nbGraine = plateau.getGraineDansTrou(numeroJoueur, numeroTrou);
        //vide le trou choisi par l'utilisateur
        plateau.viderLeTrou(numeroJoueur, numeroTrou);
        for(int i = nbGraine; i > 0; i--){
            int[] caseSuivante = caseSuivante(numeroJoueur, numeroTrou);
            numeroJoueur = caseSuivante[0];
            numeroTrou = caseSuivante[1];
            plateau.ajouteUneGraine(numeroJoueur,numeroTrou);
        }
        //caseASemer ici correspond à la dernière case semée
        return new int[]{numeroJoueur, numeroTrou};
    }

    private int[] caseSuivante(int numeroJoueur, int numeroTrou){
        //on change de joueur en arrivant au bout de plateau
        if((numeroTrou == plateau.getPlateau()[numeroJoueur].length - 1 && numeroJoueur == 0)
                ||(numeroTrou == 0 && numeroJoueur == 1)){
            numeroJoueur = (numeroJoueur +1) %2;
        }
        else if(numeroJoueur == 0)
            numeroTrou++;
        else if(numeroJoueur == 1)
            numeroTrou --;
        return new int[]{numeroJoueur, numeroTrou};
    }

    //on inverse les numéros de joueur et l'incrémentation
    private int[] casePrecedente(int numeroJoueur, int numeroTrou){
        //on change de joueur en arrivant au bout de plateau
        if((numeroTrou == plateau.getPlateau()[numeroJoueur].length - 1 && numeroJoueur == 1)
                ||(numeroTrou == 0 && numeroJoueur == 0)){
            numeroJoueur = (numeroJoueur +1) %2;
        }
        else if(numeroJoueur == 1)
            numeroTrou--;
        else if(numeroJoueur == 0)
            numeroTrou ++;
        return new int[]{numeroJoueur, numeroTrou};
    }


    private void ramasser(int numeroJoueur, int numeroTrou, Joueur joueurActif){
        while()
    //on ramasse quand la case à 2 ou 3 graines
        //on vide la case et on rajoute au score du joueur
    //si on ramasse, on check la case précedente
        //si celle ci a 2 ou 3 graines, on ramasse
    //si on ramasse pas, on s'arrête là


    /*

        int joueurAdverse;
        if(numeroJoueur == 0)
            joueurAdverse = 1;
        else joueurAdverse = 0;
        while(plateau.nbGrainerangee(joueurAdverse) > 0)
            //plateau[numeroJoueur,numeroJoueur];
            //semer(numeroJoueur, numeroTrou);
        // while pour vérifier que la ligne n'est pas vide
        //while()
        // while: vérifier si la case finale contient 2 ou 3 graines + vérifier qu'elle appartient au joueur adverse
        // la case passe à 0, le nombre de graine passe au score du joueur

     */
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
        //awale.plateau.ajouteUneGraine(1,1);
        System.out.println(awale.plateau.getGraineDansTrou(1,1));
        System.out.println(awale.plateau.getGraineDansTrou(0,1));
        System.out.println();
        //System.out.println(choixCase(0,3));;
        awale.choixCase(12);
        //var semer = semer(0, 1);
        //System.out.println(semer);
        //awale.plateau.semer(0,1);

        /*
        awale.semer(0,1);
        awale.semer(0,3);
        awale.plateau.afficherPlateau();
        awale.semer(0,4);
        //pourquoi ca sème pas ?
        awale.semer(0,4);
        awale.semer(1,3);
        awale.semer(1,4);
        awale.plateau.afficherPlateau();

         */

        //System.out.println(choixCase(11));
        //awale.semer2(0,2);
        //awale.plateau.afficherPlateau();
    }

        /*
    //test de Simon, a voir si utile
    private int[] semer2(int numeroJoueur, int numeroTrou) {
        int nbGraine = plateau.getGraineDansTrou(numeroJoueur, numeroTrou);
        int caseASemer = numeroTrou;
        while (nbGraine != 0) {
            plateau.ajouteUneGraine(numeroJoueur, caseASemer);
            caseASemer++;
            nbGraine--;
        }
        return new int[]{numeroJoueur, caseASemer};
    }

     */

}
