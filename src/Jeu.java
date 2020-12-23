public class Jeu implements Regles {
    //private static PlateauJeu plateau;
    private Joueur J1;
    private Joueur J2;
    private PlateauJeu plateau;
    private boolean coupPossible;

    //On utilise le constructeur vide pour travailler sur la version de base de l'Awale
    public Jeu(){
        this.J1 = new Joueur("SUD");
        this.J2 = new Joueur("NORD");
        this.plateau = new PlateauJeu(2,6, 4);
    }

    @Override
    public void choixPremierJoueur(){

    }

    @Override
    public void joueurSuivant(){

    }

    @Override
    public void joueurUnCoup() {

    }

    public static void main(String[] args) {
        Jeu awale = new Jeu();
        System.out.println(awale.plateau.toString());
    }

}
