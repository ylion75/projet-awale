import java.util.Scanner;

public class Jeu implements Regles {
    protected PlateauJeu plateau;
    protected Joueur J1;
    protected Joueur J2;
    private boolean finDepartie;

    /**
     * Le constructeur vide permet de lancer la version classique de l'Awale
     */
    public Jeu() {
        this.J1 = new Joueur("SUD");
        this.J2 = new Joueur("NORD");
        this.plateau = new PlateauJeu(2, 6, 4);
        boolean finDePartie = false;
    }

    public void run(){
        while(!this.getFinDePartie()){
            int choixJ1 = demanderCase(J1);
            if(choixJ1 > -1){
                jouerUnCoup(J1,choixJ1));
                int choixJ2 = demanderCase(J2);
                if(choixJ2 > -1){
                    jouerUnCoup(J2,demanderCase(J2));
                }
            }
        }
    }

    /**
     * Par défaut, c'est le Joueur 1 qui commence.
     *
     * @return J1
     */
    @Override
    public Joueur premierJoueur() {
        return J1;
    }

    public int demanderCase(Joueur joueurActif){
        int saisieUtilisateur = 0;
        Scanner sc = new Scanner(System.in);
        saisieUtilisateur = sc.nextInt();
        int saisieTraitee = convertisseurLigne(saisieUtilisateur, joueurActif);
        return saisieTraitee;
    }

    /*
    public boolean coupPossible(Joueur joueurActif, int caseSaisie){
    if(caseSaisie < 0 || caseSaisie > 12)
        return false;
    else if(joueurActif == J1 && caseSaisie > 7){
        return false;
        }
    else if(joueurActif == J2 && caseSaisie > 12){
        return false;
    }
    else return true;
    }

     */

    private boolean checkSiCasePrenable(int numeroJoueur, int numeroTrou){
        if(plateau.getGraineDansTrou(numeroJoueur,numeroTrou) >= 2 && plateau.getGraineDansTrou(numeroJoueur,numeroTrou) <=3)
            return true;
        else return false;
    }

    @Override
    public void jouerUnCoup(Joueur joueurActif, int choixValide){
        //a vérifier demain
        //int indiceCase = choixCase(choixUtilisateur);
        //rappel : on a déjà l'indice avant
        int[] derniereCase= semer(joueurActif.getNumero(),choixValide);
        while(plateau.nbGrainerangee(joueurActif.getNumero()) > 0 && checkIfCoteAdverse(joueurActif, J1.getNumero())) {
            ramasserCasePrecedente(0,choixValide, joueurActif);
            ramasserCaseSuivante(0,choixValide, joueurActif);
        }
    }

    /**
     *
     * @param joueurActif
     * @param coteJoueurActif
     * @return true si on est du côté adverse (pour manger)
     */
    public boolean checkIfCoteAdverse(Joueur joueurActif, int coteJoueurActif){
        if(joueurActif.getNumero() != coteJoueurActif )
            return true;
        else return false;
    }


    public int choisitUneCase(Joueur joueurActif) {
        int caseTape;
        try (Scanner choixS = new Scanner(System.in);) {
            System.out.println("Choissiez une case de votre ligne : " + joueurActif.getNom());
            caseTape = choixS.nextInt();
            while (caseTape < 0 || caseTape >= 13) {
                System.out.println("Et aussi dans le jeu");
                caseTape = choixS.nextInt();
            }
            if(caseTape == 0){
                this.setFinDepartie();
            }
            else if (joueurActif == J1) {
                while (isTrouVide(J2.getNumero(), convertisseurLigne(caseTape, J1))) {
                    System.out.println("Une case avec des graines  !");
                    caseTape = choixS.nextInt();
                }
                while (caseTape > 6 || caseTape < 0) {
                    System.out.println("on a dit dans ta ligne ! (ligne " + joueurActif.getNom() + ")");
                    caseTape = choixS.nextInt();
                }
            }
            else if (joueurActif == J2) {
                while (isTrouVide(J1.getNumero(), convertisseurLigne(caseTape, J2)) == true) {
                    System.out.println("Une case avec des graines !");
                    caseTape = choixS.nextInt();
                }
                while (caseTape < 7 || caseTape > 13) {
                    System.out.println("on a dit dans ta ligne !(ligne " + joueurActif.getNom() + ")");
                    caseTape = choixS.nextInt();
                }
            }
        }
        return caseTape;
    }

    public int convertisseurLigne (int choixUtilisateur, Joueur joueurActif){
        int caseConvertie = 0;
        assert(choixUtilisateur >= 0 && choixUtilisateur <= 12);
        //if(!isTrouVide)
        if(joueurActif == J1) {
            if (choixUtilisateur > 6) {
                caseConvertie = (choixUtilisateur - 12) * (-1);
            } else if (choixUtilisateur <= 6) {
                caseConvertie = choixUtilisateur - 1;
            }
        }
        else if(joueurActif == J2) {
            if (choixUtilisateur > 6) {
                caseConvertie = (choixUtilisateur - 12) * (-1);
            }
            else if (choixUtilisateur <= 6) {
                caseConvertie = choixUtilisateur - 1;
            }
        }
        else if(choixUtilisateur == 0){
            finDepartie = true;
            return -1;
        }
        return caseConvertie;
    }
    //ancienne version




    /**
     * Reinitialise la case choisie à 0 et séme les cases suivantes selon le nombre de graine de la case
     * @param numeroJoueur
     * @param numeroTrou
     * @return coordonnées de la case sur laquelle on s'arrête de semer
     *
     */
    public int[] semer(int numeroJoueur, int numeroTrou){
        int nbGraine = plateau.getGraineDansTrou(numeroJoueur, numeroTrou);
        //vide le trou choisi par l'utilisateur
        plateau.viderLeTrou(numeroJoueur, numeroTrou);
        for(int i = nbGraine; i > 0; i--){
            int[] caseSuivante = plateau.caseSuivante(numeroJoueur, numeroTrou);
            numeroJoueur = caseSuivante[0];
            numeroTrou = caseSuivante[1];
            plateau.ajouteUneGraine(numeroJoueur,numeroTrou);
        }
        //coordonnées case sur laquelle on s'arrête de semer
        return new int[]{numeroJoueur, numeroTrou};
    }

    public void ramasserGraine(int numeroJoueur, int numeroTrou, Joueur joueurActif){
        int nbGraineCaseJouee = plateau.getGraineDansTrou(numeroJoueur, numeroTrou);
        if(nbGraineCaseJouee >= 2 || nbGraineCaseJouee <= 3){
            joueurActif.setScore(nbGraineCaseJouee);
            plateau.viderLeTrou(numeroJoueur, numeroTrou);
        }
        this.finDePartieParNBGraines();
    }

    private void finDePartieParNBGraines(){
        if(plateau.nbGrainesRestantes() < 3){
            this.setFinDepartie();
            System.out.println("Plus assez de graines !");
        }
    }

    public void ramasserCaseSuivante(int numeroJoueur, int numeroTrou, Joueur joueurActif){
        int[] caseSuivante = plateau.caseSuivante(numeroJoueur, numeroTrou);
        if(checkCaseSuivantePrenable(numeroJoueur, numeroTrou))
            ramasserGraine(caseSuivante[0],caseSuivante[1], joueurActif);
    }

    public void ramasserCasePrecedente(int numeroJoueur, int numeroTrou, Joueur joueurActif){
        int[] casePrecedente = plateau.casePrecedente(numeroJoueur, numeroTrou);
        if(checkCasePrecedente(numeroJoueur, numeroTrou))
            ramasserGraine(casePrecedente[0],casePrecedente[1], joueurActif);
    }

    private boolean checkCaseSuivantePrenable(int numeroJoueur, int numeroTrou){
        int[]graineCaseSuivante = plateau.caseSuivante(numeroJoueur, numeroTrou);
        if(plateau.getGraineDansTrou(graineCaseSuivante[0], graineCaseSuivante[1])>= 2 && plateau.getGraineDansTrou(graineCaseSuivante[0], graineCaseSuivante[1])<= 3)
            return true;
        else return false;
    }

    private boolean checkCasePrecedente(int numeroJoueur, int numeroTrou){
        int[]graineCasePrecedente = plateau.casePrecedente(numeroJoueur, numeroTrou);
        if(plateau.getGraineDansTrou(graineCasePrecedente[0], graineCasePrecedente[1])>= 2 && plateau.getGraineDansTrou(graineCasePrecedente[0], graineCasePrecedente[1])<= 3)
            return true;
        else return false;
    }

    public boolean isTrouVide(int numeroJoueur, int numeroTrou){
        if(plateau.getGraineDansTrou(numeroJoueur,numeroTrou) == 0)
            return true;
        else return false;
    }


    public void setFinDepartie() {
        this.finDepartie = true;
    }

    public boolean getFinDePartie() {
        return finDepartie;
    }

    public Joueur[] getJoueurs() {
        return new Joueur[]{J1, J2};
    }

    public Joueur joueurSuivant(Joueur joueurActuel) {
        if (joueurActuel == J1) {
            return J1;
        } else return J2;
    }

    /*
     * @param choixUtilisateur
     * @return prend le choix de l'utilisateur et renvoie en indice du tableau
     */

    /*
    public int choixCase(int choixUtilisateur){
        int caseChoisie = 0;
        assert(choixUtilisateur >= 0 && choixUtilisateur <= 12);
        if(choixUtilisateur > 0 && choixUtilisateur < 7){
            caseChoisie = choixUtilisateur - 1;
        }
        else if(choixUtilisateur > 6) {
            caseChoisie = (choixUtilisateur - 12) * (-1);
        }
        else if(choixUtilisateur == 0){
            finDepartie = true;
            return -1;
        }
        return caseChoisie;
    }

     */

}
