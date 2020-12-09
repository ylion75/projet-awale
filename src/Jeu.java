public class Jeu {
    private Joueur J1;
    private Joueur J2;
    private boolean coupPossible;

    private Jeu(){
        this.J1 = new Joueur("SUD");
        this.J2 = new Joueur("NORD");
    }

    /* methodes à créer */
    public int choisirTrou(){
        //je sais pas trop si c'est un int ou si c'est un tableau de trou

        return 0;
    }
    public void coupPossible(){
        //il y a au moins une graine dans la case
    }
    public int jouerCoup(){
        /* Peut-être à diviser en sous méthodes */
        //semeGraine(): prend les graines d'une case et rajoute sur les cases suivantes (de manière circulaire)
        //++ : (en lien avec circulaire) "le semi continue dans le sens inverse à partir du trou adjacent de la rangée opposée"
        //si trou de départ a assez de graine (boolean ?): on sème
    }


    choisir case
    //déplacer graines
    //ramasser

}
