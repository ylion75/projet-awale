public class Appli extends Jeu {
    private static Jeu awale;

    /*
    public void joue(Joueur joueurActif){
        if(joueurActif == J1){
            awale.jouerUnCoup(joueurActif,;

        }
        else if(joueurActif == J2){

        }
    }

     */


    public static void main(String[] args) {
        awale = new Jeu();
        //joueurActif = new Joueur();
        awale.plateau.afficherPlateau();
        /*
        while(!awale.finDePartie()){
            awale.jouerUnCoup(awale.J1, awale.demanderCase(awale.J1));
            awale.plateau.afficherPlateau();
        }

         */
        /*
        if (joueurActif == awale.J1) {
            int choixJ1 = awale.choisitUneCase(awale.J1);
            awale.semer(0, choixJ1);
            awale.jouerUnCoup(awale.J1, choixJ1);
            awale.joueurSuivant(awale.J1);
            joueurActif = awale.joueurSuivant(awale.J1);
        } else if (joueurActif == awale.J2) {
            int choixJ2 = awale.choisitUneCase(awale.J2);
            awale.jouerUnCoup(awale.J2, choixJ2);
            awale.joueurSuivant(awale.J2);
            joueurActif = awale.joueurSuivant(awale.J2);
        }
        
         */

        //
        //
        // joueurActif = awale.joueurSuivant(awale.J1);



    }
}




        /*

        awale.ramasser(0,2, awale.J1);
        awale.ramasserCasePrecedente(0,2, awale.J1);
        awale.plateau.afficherPlateau();
        System.out.println();
        System.out.println("Le prochain c'est case suivante");

        awale.ramasser(0,2, awale.J1);
        awale.ramasserCaseSuivante(0,2, awale.J1);
        awale.plateau.afficherPlateau();

        awale.ramasser(1,2, awale.J1);
        awale.ramasserCaseSuivante(1,2, awale.J1);
        awale.plateau.afficherPlateau();

        int test = awale.choixDuJoueur(awale.J1);
        System.out.println(test);



        /*
        //test Simon
        awale.plateau.setGraineDansTrou(0,0,3);
        awale.plateau.setGraineDansTrou(0,1,3);
        awale.plateau.setGraineDansTrou(0,2,3);



        //Test ramasser case  suivante
        awale.ramasser(0,2, awale.J1);
        awale.ramasserCasePrecedente(0,2, awale.J1);
        awale.plateau.afficherPlateau();
        System.out.println();
        System.out.println("Le prochain c'est case suivante");

        awale.ramasser(0,2, awale.J1);
        awale.ramasserCaseSuivante(0,2, awale.J1);
        awale.plateau.afficherPlateau();




        //Jeu de test à l'arrache pour ramasser
        System.out.println(awale.plateau.getGraineDansTrou(1,1));
        awale.plateau.setGraineDansTrou(0,1,3);
        awale.plateau.afficherPlateau();
        awale.ramasser(0,1, awale.J1);
        awale.plateau.afficherPlateau();
        int scoreTest = awale.J1.getScore();
        //int scoreTest = awale.J1.getScore();
        System.out.println(scoreTest);

         */





