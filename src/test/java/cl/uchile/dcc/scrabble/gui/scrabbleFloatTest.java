package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleFloatTest {
    private scrabbleFloat scrFloat;
    private Double sFloat;
    private int seed;
    private Random rng;
    @BeforeEach
    void Setup() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        sFloat = rng.nextDouble()*10000;
        scrFloat = new scrabbleFloat(sFloat);
    }
    @RepeatedTest(20)
    void testConstructor() {
        var expectedScrabble = new scrabbleFloat(sFloat);
        assertEquals(expectedScrabble,scrFloat);
        assertEquals(expectedScrabble.hashCode(),scrFloat.hashCode());
        double differentFloat;
        do {
            differentFloat = rng.nextDouble();
        }while (differentFloat == sFloat);
        var differentScrabble = new scrabbleFloat(differentFloat);
        assertNotEquals(differentScrabble,scrFloat);
    }
    @RepeatedTest(20)
    void testToString(){
        assertEquals(sFloat.toString(),scrFloat.toString());
    }
    @RepeatedTest(20)
    void testToScrString(){
        var expectedScrStr = new scrabbleString(sFloat.toString());
        assertEquals(expectedScrStr,scrFloat.toScrString());
    }
    @RepeatedTest(20)
    void testToScrBool(){
        assertNull(scrFloat.toScrBool());
    }
    @RepeatedTest(20)
    void testToScrFloat(){
        var expectedFloat = new scrabbleFloat(sFloat);
        assertEquals(expectedFloat,scrFloat.toScrFloat());
    }
    @RepeatedTest(20)
    void testToScrInt(){
        assertNull(scrFloat.toScrInt());
    }
    @RepeatedTest(20)
    void testToScrBin(){
        assertNull(scrFloat.toScrBin());
    }
}