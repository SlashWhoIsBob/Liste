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

    public int getElementAt(int index) {
        int indexCourant = 0;
        for(Noeud courant = premier; courant != null; courant = courant.prochain) {
            if(indexCourant == index)
                return courant.valeur;
            indexCourant++;
        }
        return -1;
    }

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

    // Inutile dans ce code !!!
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

    public boolean trouverTout(Liste autre) {
        for(Noeud courant = autre.premier; courant != null; courant = courant.prochain) {
            if (this.trouver(courant.valeur) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean effacerAt(int index) {
        if (index < 0 || index > nbElements)
            return false;

        if(index == 0) {
            premier = premier.prochain;
        }

        Noeud precedent = premier;
        for (int i = 0; i < index - 1; i++) {
            precedent = precedent.prochain;
        }

        precedent.prochain = precedent.prochain.prochain;
        nbElements--;
        return true;
    }

    public boolean effacerTout(Liste autre) {
        boolean modifie = false;

        Noeud courant = premier;
        Noeud precedent = null;

        while (courant != null) {
            if (autre.trouver(courant.valeur) != -1) {
                if (precedent == null) {
                    premier = courant.prochain;
                } else {
                    precedent.prochain = courant.prochain;
                }
                courant = courant.prochain;
                nbElements--;
                modifie = true;
            } else {
                precedent = courant;
                courant = courant.prochain;
            }
        }
        return modifie;
    }

    public void effacerTout() {
        premier = null;
        nbElements = 0;
    }

}