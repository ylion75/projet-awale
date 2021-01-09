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
        this.plateau.afficherPlateau();
    }

    /**
     * Par défaut, c'est le Joueur 1 qui commence.
     * @return J1
     */
    @Override
    public Joueur premierJoueur() {
        return J1;
    }

    public Joueur[] getJoueurs() {
        return new Joueur[]{J1, J2};
    }

    public boolean getFinDePartie() {
        return finDepartie;
    }

    public void setFinDepartie() {
        this.finDepartie = true;
    }

    /**
     * Permet de convertir la saisie de l'utilisateur
     * @param choixUtilisateur
     * @param joueurActif
     * @return l'indice du tableau correspondant
     */
    private int convertisseurLigne (int choixUtilisateur, Joueur joueurActif){
        int caseConvertie = 0;
        assert(choixUtilisateur >= 0 && choixUtilisateur <= 12);
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

    /**
     * Tant que le Trou est prenable, vide le Trou et incrémente le score du joueur puis vérifie le trou d'à côté
     * @param numeroJoueur
     * @param numeroTrou
     * @param joueurActif
     */
    public void ramasserGraine(int numeroJoueur, int numeroTrou, Joueur joueurActif){
        int nbGraineCaseJouee = plateau.getGraineDansTrou(numeroJoueur, numeroTrou);
        while(checkSiCasePrenable(numeroJoueur,numeroTrou,joueurActif)){
            joueurActif.setScore(nbGraineCaseJouee);
            plateau.viderLeTrou(numeroJoueur, numeroTrou);
        }
        this.finDePartieParNBGraines();
    }

    /**
     * Vérifie que la case contient entre 2 et 3 graines et qu'on se situe dans le côté du joueur adverse
     * @param numeroJoueur
     * @param numeroTrou
     * @param joueurActif
     * @return
     */
    private boolean checkSiCasePrenable(int numeroJoueur, int numeroTrou, Joueur joueurActif){
        if((plateau.getGraineDansTrou(numeroJoueur,numeroTrou) >= 2 && plateau.getGraineDansTrou(numeroJoueur,numeroTrou) <=3)
                &&( joueurActif.getNumero() != numeroJoueur))
            return true;
        else return false;
    }

    /**
     * Mets fin à la partie lorsqu'il y a moins de 3 graines sur le plateau
     */
    private void finDePartieParNBGraines(){
        if(plateau.nbGrainesRestantes() < 3){
            this.setFinDepartie();
            System.out.println("Plus assez de graines !");
        }
    }

    private boolean isTrouVide(int numeroJoueur, int numeroTrou){
        if(plateau.getGraineDansTrou(numeroJoueur,numeroTrou) == 0)
            return true;
        else return false;
    }

    /**
     * Reinitialise la case choisie à 0 et séme les cases suivantes selon le nombre de graine de la case
     * @param numeroJoueur
     * @param numeroTrou
     * @return les coordonnées de la case sur laquelle on s'arrête de semer
     *
     */
    public int[] semer(int numeroJoueur, int numeroTrou){
        int nbGraine = plateau.getGraineDansTrou(numeroJoueur, numeroTrou);
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

    /**
     * Demande la case à l'utilisateur et vérifie que la case appartient à sa partie du tableau
     * @param joueurActif
     * @return l'indice du tableau qui correspond
     */
    private int demandeCase(Joueur joueurActif) {
        int saisieUtilisateur = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choissiez une case de votre ligne : " + joueurActif.getNom());
        if (saisieUtilisateur == 0) {
            this.setFinDepartie();
        }
        while ((joueurActif == J1 && (saisieUtilisateur < 1 || saisieUtilisateur > 6))
                || (joueurActif == J2 && (saisieUtilisateur < 7 || saisieUtilisateur > 12))
                || (isTrouVide(joueurActif.getNumero(), convertisseurLigne(saisieUtilisateur, joueurActif)))) {
            System.out.println("J1 joue entre 1 et 6, J2 joue entre 7 et 12");
            try {
                saisieUtilisateur = sc.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return convertisseurLigne(saisieUtilisateur,joueurActif);
    }

    /* TODO: Ancienne version, a supprimer une fois que l'affichage sera remis
    public int choisitUneCase(Joueur joueurActif) {
        int caseTape = -1;
        try (Scanner choixS = new Scanner(System.in);) {
            System.out.println("Choissiez une case de votre ligne : " + joueurActif.getNom());
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
    */

    /**
     * 
     * @param joueurActif
     * @param choixValide
     */
    @Override
    public void jouerUnCoup(Joueur joueurActif, int choixValide){
        int[] derniereCase= semer(joueurActif.getNumero(),choixValide);
        ramasserGraine(derniereCase[0], derniereCase[1], joueurActif);
        plateau.afficherPlateau();
    }

    public void deroulePartie(){
        while(!this.getFinDePartie()){
            int choixJ1 = demandeCase(J1);
            if(choixJ1 > -1){
                jouerUnCoup(J1,choixJ1);
                int choixJ2 = demandeCase(J2);
                if(choixJ2 > -1){
                    jouerUnCoup(J2,choixJ2);
                }
            }
        }
    }
}
