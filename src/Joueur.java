public class Joueur {
    private String nom;
    private int numero;
    private static int cpt = 0;

    public Joueur(String nom){
        this.nom = nom;
        this.numero = ++cpt;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }
}