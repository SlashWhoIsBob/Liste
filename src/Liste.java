public class Liste {
    private Noeud premier;
    private int nbElements;

    public Liste() {
        premier = null;
        nbElements = 0;
    }

    public String toString() {
        String str = "[";
        for (Noeud courant = premier; courant != null; courant = courant.prochain)
            str += courant.valeur + ", ";
        return str + "]";
    }

    public int getNbElements() {
        return nbElements;
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    public int getElementAt(int index) {
        return getNoeudAt(index).valeur;
    }

    private Noeud getNoeudAt(int index) {
        for (Noeud courant = premier; courant != null; courant = courant.prochain)
            if (index-- == 0)
                return courant;
        return null;
    }

    public void ajouter(int valeur) {
        //tableau[nbElements++] = valeur;

        Noeud dernier = null;
        for (Noeud courant = premier; courant != null; courant = courant.prochain)
            dernier = courant;

        if (dernier == null) {
            premier = new Noeud(valeur);
        }
        else {
            dernier.prochain = new Noeud(valeur);
        }
        nbElements++;
    }

    public boolean ajouter(int valeur, int index) {
        if (index < 0 || index > nbElements)
            //throw new IndexOutOfBoundsException();
            return false;

        Noeud precedent = getNoeudAt(index - 1);
        Noeud nouveau = new Noeud(valeur);

        if (index == 0) {
            nouveau.prochain = premier;
            premier = nouveau;
        }
        else {
            nouveau.prochain = precedent.prochain;
            precedent.prochain = nouveau;
        }

        nbElements++;
        return true;
    }

    public void ajouter(Liste autre) {
        for (int i = 0; i < autre.getNbElements(); i++)
            this.ajouter(autre.getElementAt(i));
    }

    public int trouver(int valeur) {
        int index = 0;
        for (Noeud courant = premier; courant != null; courant = courant.prochain) {
            if (courant.valeur == valeur)
                return index;
            else
                index++;
        }
        return -1;
    }

    public boolean trouverTout(Liste autre) {
        for (int i = 0; i < autre.getNbElements(); i++)
            if (this.trouver(autre.getElementAt(i)) == -1)
                return false;
        return true;
    }

    public boolean effacerAt(int index) {
        if (index < 0 || index > nbElements)
            return false;

        if (index == 0) {
            premier = premier.prochain;
        }
        else {
            Noeud precedent = getNoeudAt(index - 1);
            precedent.prochain = precedent.prochain.prochain;
        }

        nbElements--;
        return true;
    }

    public boolean effacerTout(Liste autre) {
        boolean modifie = false;
        for (int i = 0; i < autre.getNbElements(); i++) {
            int valeurCherchee = autre.getElementAt(i);
            int indexTrouve = this.trouver(valeurCherchee);
            if (indexTrouve != -1) {
                effacerAt(indexTrouve);
                modifie = true;
            }
        }
        return modifie;
    }

    public void effacerTout() {
        premier = null;
        nbElements = 0;
    }
}