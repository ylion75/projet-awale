public class Joueur {
    private String nom;
    private int numero;
    private static int cpt = 0; //compteur static pour attribuer un numéro au joueur
    private int cptPoint;

    public Joueur(String nom){
        this.nom = nom;
        this.numero = ++cpt;
        this.cptPoint = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }
}
