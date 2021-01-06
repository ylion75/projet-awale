public interface Regles {
    //L'interface permet de spécifier les règles, elle doit permettre les extensions futures et notamment l'ajout de règles supplémentaires.
    //Les méthodes sont publiques et non définies

    //int ou void ?
    public Joueur premierJoueur();
    public Joueur joueurSuivant(Joueur joueurActuel);
    public void jouerUnCoup(Joueur joueurActif, int numeroJoueur, int numeroTrou);
    public boolean finDePartie();

}
