package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
class ScrabbleIntTest {
    private scrabbleInt scrInt;
    private Integer sInt;
    private int seed;
    private Random rng;
    @BeforeEach
    void Setup() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        sInt = rng.nextInt(10000);
        scrInt = new scrabbleInt(sInt);
    }
    @RepeatedTest(20)
    void testConstructor() {
        var expectedScrabble = new scrabbleInt(sInt);
        assertEquals(expectedScrabble,scrInt);
        assertEquals(expectedScrabble.hashCode(),scrInt.hashCode());
        Integer differentInt;
        do {
            differentInt = rng.nextInt(10000);
        }while (differentInt.equals(sInt));
        var differentScrabble = new scrabbleInt(differentInt);
        assertNotEquals(differentScrabble,scrInt);
    }
    @RepeatedTest(20)
    void testToString(){
        assertEquals(sInt.toString(),scrInt.toString());
    }
    @RepeatedTest(20)
    void testToScrString(){
        var expectedScrStr = new scrabbleString(sInt.toString());
        assertEquals(expectedScrStr,scrInt.toScrString());
    }
    @RepeatedTest(20)
    void testToScrBool(){
        assertNull(scrInt.toScrBool());
    }
    @RepeatedTest(20)
    void testToScrFloat(){
        var expectedFloat = new scrabbleFloat(sInt.doubleValue());
        assertEquals(expectedFloat,scrInt.toScrFloat());
    }
    @RepeatedTest(20)
    void testToScrInt(){
        var expectedInt = new scrabbleInt(sInt);
        assertEquals(expectedInt,scrInt.toScrInt());
    }
    @Test
    void testToScrBin(){
        String sieteBin = "0111";
        scrabbleInt sieteInt = new scrabbleInt(7);
        var expectedBin = new scrabbleBinary(sieteBin);
        assertEquals(expectedBin,sieteInt.toScrBin());
        String menosSieteBin = "1001";
        scrabbleInt menosSieteInt = new scrabbleInt(-7);
        var expectedBin2 = new scrabbleBinary(menosSieteBin);
        assertEquals(expectedBin2,menosSieteInt.toScrBin());
        String veinteBin = "010100";
        scrabbleInt veinteInt = new scrabbleInt(20);
        var expectedBin3 = new scrabbleBinary(veinteBin);
        assertEquals(expectedBin3,veinteInt.toScrBin());
        String menosVeinteBin = "101100";
        scrabbleInt menosVeinteInt = new scrabbleInt(-20);
        var expectedBin4 = new scrabbleBinary(menosVeinteBin);
        assertEquals(expectedBin4,menosVeinteInt.toScrBin());



    }
}