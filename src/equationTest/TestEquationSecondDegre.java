package equationTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import jmf.equation.PolynomeSecondDegre;

public class TestEquationSecondDegre {

    @Test
    public void test2Racines() {
        PolynomeSecondDegre polynome = new PolynomeSecondDegre(1, 1, -2);
        double[] racines = polynome.calculRacines();
        double[] expectedRacines = {1, -2};
        assertArrayEquals(expectedRacines, racines, 0.001);
    }

    @Test
    public void test1Racine() {
        PolynomeSecondDegre polynome = new PolynomeSecondDegre(1, -2, 1);
        double[] racines = polynome.calculRacines();
        double[] expectedRacines = {1};
        assertArrayEquals(expectedRacines, racines, 0.001);
    }

    @Test
    public void testPasDeRacineReelle() {
        PolynomeSecondDegre polynome = new PolynomeSecondDegre(1, 1, 1);
        double[] racines = polynome.calculRacines();
        assertNull(racines);
    }
}