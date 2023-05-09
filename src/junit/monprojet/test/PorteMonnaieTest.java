package junit.monprojet.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import junit.monprojet.PorteMonnaie;
import junit.monprojet.SommeArgent;

public class PorteMonnaieTest {

    private PorteMonnaie porteMonnaie;
    private SommeArgent somme1, somme2, somme3;

    @Before
    public void setUp() {
        porteMonnaie = new PorteMonnaie();
        somme1 = new SommeArgent(10, "USD");
        somme2 = new SommeArgent(20, "USD");
        somme3 = new SommeArgent(30, "EUR");
    }

    @Test
    public void testAjouteSomme() {
        porteMonnaie.ajouteSomme(somme1);
        porteMonnaie.ajouteSomme(somme2);
        porteMonnaie.ajouteSomme(somme3);

        assertNotNull(porteMonnaie.getContenu());
        assertEquals(2, porteMonnaie.getContenu().size());
        assertEquals(Integer.valueOf(30), porteMonnaie.getContenu().get("USD"));
        assertEquals(Integer.valueOf(30), porteMonnaie.getContenu().get("EUR"));
    }

    @Test
    public void testEquals() {
        PorteMonnaie anotherPorteMonnaie = new PorteMonnaie();
        anotherPorteMonnaie.ajouteSomme(somme1);
        anotherPorteMonnaie.ajouteSomme(somme2);
        anotherPorteMonnaie.ajouteSomme(somme3);

        assertEquals(porteMonnaie, anotherPorteMonnaie);

        anotherPorteMonnaie.ajouteSomme(new SommeArgent(5, "USD"));
        assertFalse(porteMonnaie.equals(anotherPorteMonnaie));
    }
}