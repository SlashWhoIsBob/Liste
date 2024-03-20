import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
    @Test
    void getNbElements() {
        Liste test = new Liste();
        assertEquals(0, test.getNbElements());

        test.ajouter(0);
        assertEquals(1, test.getNbElements());

        test.ajouter(0);
        assertEquals(2, test.getNbElements());
    }

    @Test
    void estVide() {
    }

    @Test
    void getElementAt() {
    }

    @Test
    void ajouter() {
    }

    @Test
    void testAjouter() {
    }

    @Test
    void testAjouter1() {
    }

    @Test
    void trouver() {
    }

    @Test
    void trouverTout() {
    }

    @Test
    void effacerAt() {
    }

    @Test
    void effacerTout() {
    }

    @Test
    void testEffacerTout() {
    }
}