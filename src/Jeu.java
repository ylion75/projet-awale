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
     * Mets fin à la partie lorsqu'il y a moins de 3 graines sur le plateau
     */
    private void finDePartieParNBGraines(){
        if(plateau.getNBGrainesRestantes() < 3){
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
     * Permet de convertir la saisie de l'utilisateur
     * @param choixUtilisateur
     * @param joueurActif
     * @return l'indice de la case correspondant au choix de l'utilisateur. Le 0 renvoie 0 et mets fin à la partie.
     */
    protected int convertisseurLigne(int choixUtilisateur, Joueur joueurActif){
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
            this.finDepartie = true;
            return -1;
        }
        return caseConvertie;
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
     * Tant que le Trou est prenable, vide le Trou et i
     * Incrémente le score du joueur puis vérifie le trou d'à côté
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
     * saisieUtilisateur initialisée à -1 car si 0 le boolean finDePartie passe a true
     * @param joueurActif
     * @return l'indice du tableau qui correspond
     */
    private int demandeCase(Joueur joueurActif) {
        int saisieUtilisateur = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nord a " + J1.getScore() + " graine(s)" );
        System.out.println("Sud a " + J2.getScore() + " graine(s)");
        System.out.println("Choissiez une case de votre ligne : " + joueurActif.getNom());
        if (saisieUtilisateur == 0) {
            this.setFinDepartie();
        }
        while ((joueurActif == J1 && (saisieUtilisateur < 1 || saisieUtilisateur > 6))
                || (joueurActif == J2 && (saisieUtilisateur < 7 || saisieUtilisateur > 12))
                || (isTrouVide(joueurActif.getNumero(), convertisseurLigne(saisieUtilisateur, joueurActif)))) {
            if(joueurActif == J1)
                System.out.println("Jouez entre 1 et 6");
            else if (joueurActif == J2)
                System.out.println("Jouez entre 7 et 12");
            try {
                saisieUtilisateur = sc.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return convertisseurLigne(saisieUtilisateur,joueurActif);
    }

    /**
     * Récupère la dernière case sur laquelle on a semé
     * Invoque ramasserGraine qui ramasse la case et celles concomittantes si c'est possible
     * @param joueurActif
     * @param choixValide
     */
    @Override
    public void jouerUnCoup(Joueur joueurActif, int choixValide){
        int[] derniereCase= semer(joueurActif.getNumero(),choixValide);
        semer(joueurActif.getNumero(),choixValide);
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
