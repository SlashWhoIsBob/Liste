public class Liste {
    private Noeud premier, dernier;
    private int nbElements;

    public Liste() {
        premier = dernier = null;
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
        if(index >= 0) {
            for (Noeud courant = premier; courant != null; courant = courant.prochain)
                if (index-- == 0)
                    return courant;
        } else {
            for (Noeud courant = dernier; courant != null; courant = courant.precedent)
                if (++index == 0)
                    return courant;
        }
        return null;
    }

    public boolean ajouter(int valeur) {
        if (estVide()) {
            premier = new Noeud(valeur);
            dernier = premier;
        }
        else {
            Noeud nouveau = new Noeud(valeur);
            dernier.prochain = nouveau;
            nouveau.precedent = dernier;
            dernier = dernier.prochain;
        }
        nbElements++;
        return true;
    }

    public boolean ajouter(int valeur, int index) {
        if (index < -nbElements || index > nbElements)
            return false;

        Noeud precedent = getNoeudAt(index - 1);
        Noeud nouveau = new Noeud(valeur);

        if (index == 0) {
            nouveau.prochain = premier;
            nouveau.precedent = null;
            premier = nouveau;
        } else if(index == nbElements || index == -1) {
            return ajouter(valeur);
        } else {
            nouveau.prochain = precedent.prochain;
            nouveau.precedent = precedent;
            precedent.prochain = nouveau;
            nouveau.prochain.precedent = nouveau;
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
        if (index < -nbElements || index > nbElements)
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