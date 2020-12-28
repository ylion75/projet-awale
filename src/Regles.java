public interface Regles {
    //L'interface permet de spécifier les règles, elle doit permettre les extensions futures et notamment l'ajout de règles supplémentaires.
    //Les méthodes sont publiques et non définies

    //int ou void ?
    public int premierJoueur();
    public int joueurSuivant(int joueurActuel);
    public void joueurUnCoup();
    public abstract boolean finDePartie();

}
