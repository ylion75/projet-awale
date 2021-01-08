public interface Regles {
    //L'interface permet de spécifier les règles, elle doit permettre les extensions futures et notamment l'ajout de règles supplémentaires.
    //Les méthodes sont publiques et non définies

    public Joueur premierJoueur();
    public void jouerUnCoup(Joueur joueurActif, int choixUtilisateur);

}
