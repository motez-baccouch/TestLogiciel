package junit.monprojet.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import junit.monprojet.SommeArgent;
import junit.monprojet.UniteDistincteException;

public class TestSommeArgprivate {

	SommeArgent somme1, somme2, somme3, somme4;

@Before
public void setUp() {
    somme1 = new SommeArgent(10, "USD");
    somme2 = new SommeArgent(20, "USD");
    somme3 = new SommeArgent(30, "EUR");
    somme4 = new SommeArgent(10, "USD");
}

@Test
public void testEquals() {
    assertEquals(somme1, somme4);
    assertNotEquals(somme1, somme2);
    assertNotEquals(somme1, somme3);
}

@Test
public void testAdd() throws UniteDistincteException {
    SommeArgent sommeResult = somme1.add(somme2);
    assertNotNull(sommeResult);
    assertEquals(new SommeArgent(30, "USD"), sommeResult);
}

@Test(expected = UniteDistincteException.class)
public void testAddDifferentCurrencies() throws UniteDistincteException {
    somme1.add(somme3);
}

@Test
public void testToString() {
    String expectedString = "10 USD";
    assertTrue(somme1.toString().equals(expectedString));
}
}