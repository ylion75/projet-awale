import java.util.Scanner;

public class Appli extends Jeu {

    public static void main(String[] args) {
        Jeu awale = new Jeu();
        awale.plateau.afficherPlateau();

        int saisiePremierCoup = awale.demanderCase(awale.premierJoueur());
        if(awale.coupPossible(awale.premierJoueur(), saisiePremierCoup)){
            awale.jouerUnCoup(awale.premierJoueur(),saisiePremierCoup);
        }
        else if(!awale.coupPossible(awale.premierJoueur(), saisiePremierCoup)){
            System.out.println("Rejouez un coup");
            awale.demanderCase(awale.premierJoueur());
        }

        //scan saisie premier joueur
        //


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





    }
}