public class Noeud {
    public int valeur;
    public Noeud precedent, prochain;

    public Noeud(int valeur) {
        this.valeur = valeur;
        this.precedent = null;
        this.prochain = null;
    }

    public String toString() {
        return String.valueOf(valeur);
    }
}
