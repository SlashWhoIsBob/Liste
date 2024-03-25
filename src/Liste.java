public class Liste {
    private Noeud premier;
    private int nbElements;

    public Liste() {
        premier = null;
        nbElements = 0;
    }

    public String toString() {
        String str = "[";
        for(Noeud courant = premier; courant != null; courant = courant.prochain) {
            str += courant + ", ";
        }
        return str + "]";
    }
    public int getNbElements() {
        return nbElements;
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    /*public int getElementAt(int index) {
        return tableau[index];
    }*/

    public void ajouter(int valeur) {
        Noeud dernier = null;
        for(Noeud courant = premier; courant != null; courant = courant.prochain) {
            dernier = courant;
        }

        if(dernier == null) {
            premier = new Noeud(valeur);
        } else {
            dernier.prochain = new Noeud(valeur);
        }
        nbElements++;
    }

    public void ajouter(int valeur, int index) {
        if(index < 0 || index > nbElements) {
            return;
        }
        if(index == 0) {
            Noeud nouveau = new Noeud(valeur);
            nouveau.prochain = premier;
            premier = nouveau;
        } else {
            Noeud precedent = premier;
            for(int i = 0; i < index - 1; i++) {
                precedent = precedent.prochain;
            }

            Noeud nouveau = new Noeud(valeur);
            nouveau.prochain = precedent.prochain;
            precedent.prochain = nouveau;
        }
        nbElements++;
    }

    /* private void resize() {
        int[] nouveau = new int[RATIO_AGRANDISSEMENT * tableau.length];
        for (int i = 0; i < nbElements; i++)
            nouveau[i] = tableau[i];
        tableau = nouveau;
    }*/

    public void ajouter(Liste autre) {
        for (Noeud courant = autre.premier; courant != null; courant = courant.prochain)
            this.ajouter(courant.valeur);
    }

    public int trouver(int valeur) {
        int index = 0;
        for(Noeud courant = premier; courant != null; courant = courant.prochain) {
            if(courant.valeur == valeur) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }
/*
    public boolean trouverTout(Liste autre) {
        for (int i = 0; i < autre.getNbElements(); i++)
            if (this.trouver(autre.getElementAt(i)) == -1)
                return false;
        return true;
    }

    public boolean effacerAt(int index) {
        if (index < 0 || index > nbElements)
            return false;

        for (int i = index; i < nbElements; i++)
            tableau[i] = tableau[i + 1];
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
        //effacerTout(this);
        tableau = new int[TAILLE_INITIALE];
        nbElements = 0;
    }

     */
}