public class Regles {
    private PlateauJeu plateau;
    private int nbJoueur;
    private int[][] coupPossible;

    public Regles(int nbJoueur){
        this.nbJoueur = nbJoueur;
    }

    public void choixPremierJoueur{
        //de base renvoie le Joueur 1
        //on peut surchager avec un random pour certains mode de jeu
    }

    public void joueurSuivant(){
        //= au joueur d'après (//cpt)
    }

    public void joueurUnCoup(){
        //si coup possible (nbrGraine > 1)
        //alors semerGraine()
    }

    //methode privée parce que sous methode de joueur un coup
    private void semerGraine(){

    }




}
