public interface Regles {
    //L'interface permet de spécifier les règles, elle doit permettre les extensions futures et notamment l'ajout de règles supplémentaires.
    
    public abstract Joueur premierJoueur();
    public abstract void jouerUnCoup(Joueur joueurActif, int choixUtilisateur);
    public abstract void ramasserGraine(int numeroJoueur, int numeroTrou, Joueur joueurActif);
    public abstract int[] semer(int numeroJoueur, int numeroTrou);
    public abstract void deroulePartie();
}
