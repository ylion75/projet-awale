    public class Joueur {
    private String nom;
    private int numero;
    private static int cpt = 0; //compteur static pour attribuer un numéro au joueur
    private int score;
    private String cote;

    //je sais pas trop si ça sert
    enum cote {
        NORD,
        SUD
    }

    public Joueur(String nom){
        this.nom = nom;
        this.numero = ++cpt;
        this.score = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void ajouterScore(int score){
        setScore(this.score + score);
    }
}
