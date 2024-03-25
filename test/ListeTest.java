import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {
    Liste data;
    @BeforeEach
    void setUp() {
        data = new Liste();
        data.ajouter(0);
        data.ajouter(10);
        data.ajouter(20);
        data.ajouter(30);
        data.ajouter(40);
        data.ajouter(50);
    }

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
        assertEquals(0, data.getElementAt(0));
        assertEquals(30, data.getElementAt(3));
        assertEquals(50, data.getElementAt(5));
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