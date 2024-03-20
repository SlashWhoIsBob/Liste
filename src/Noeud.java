public class Noeud {
    public int valeur;
    public Noeud prochain;

    public Noeud(int valeur) {
        this.valeur = valeur;
    }

    public String toString() {
        return String.valueOf(valeur);
    }
}
