    public class Joueur {
    private String nom;
    private int numero;
    private int cpt = 0; //compteur static pour attribuer un numéro au joueur
    private int score;

    public Joueur(String nom){
        this.nom = nom;
        this.numero = cpt++;
        this.score = 0;
    }

    public Joueur joueurSuivant(Joueur joueurActuel) {
        if (joueurActuel == J1) {
            return J1;
        } else return J2;
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

    public int getScore(){
        return score;
        }

    public void ajouterScore(int score){
        setScore(this.score + score);
    }
}
