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
    @RepeatedTest(20)
    void testAddSubtractMultiplyDivide(){
        double differentFloat;
        do {
            differentFloat = rng.nextDouble();
        }while (differentFloat == sFloat);
        scrabbleFloat sFloat2 = new scrabbleFloat(differentFloat);
        var expectedSum = new scrabbleFloat(sFloat + differentFloat);
        assertEquals(expectedSum,scrFloat.add(sFloat2));
        var expectedRes = new scrabbleFloat(sFloat - differentFloat);
        assertEquals(expectedRes,scrFloat.subtract(sFloat2));
        var expectedMul = new scrabbleFloat(sFloat * differentFloat);
        assertEquals(expectedMul,scrFloat.multiply(sFloat2));
        var expectedDiv = new scrabbleFloat(sFloat / differentFloat);
        assertEquals(expectedDiv,scrFloat.divide(sFloat2));
        String menosSieteBin = "1001";
        String veinteBin = "010100";
        String menosVeinteBin = "101100";
        String sieteBin = "0111";
        String menosDoceBin = "10100";
        String cincuentaYTresBin ="0110101";
        var SBins = new scrabbleBinary[]{
                new scrabbleBinary(sieteBin),
                new scrabbleBinary(menosSieteBin),
                new scrabbleBinary(veinteBin),
                new scrabbleBinary(menosVeinteBin),
                new scrabbleBinary(menosDoceBin),
                new scrabbleBinary(cincuentaYTresBin)};
        for (scrabbleBinary sBin : SBins) {
            var expectedSum2 = new scrabbleFloat(sBin.toScrFloat().getsFloat() + sFloat);
            assertEquals(expectedSum2, scrFloat.add(sBin));
            var expectedRes2 = new scrabbleFloat(sFloat - sBin.toScrFloat().getsFloat());
            assertEquals(expectedRes2, scrFloat.subtract(sBin));
            var expectedMul2 = new scrabbleFloat(sFloat * sBin.toScrFloat().getsFloat());
            assertEquals(expectedMul2, scrFloat.multiply(sBin));
            var expectedDiv2 = new scrabbleFloat(sFloat / sBin.toScrFloat().getsFloat());
            assertEquals(expectedDiv2, scrFloat.divide(sBin));
        }
         Integer sInt = rng.nextInt(10000);
        scrabbleInt sI = new scrabbleInt(sInt);
        var expectedSum3 = new scrabbleFloat(sFloat + sInt);
        assertEquals(expectedSum3,scrFloat.add(sI));
        var expectedRes3 = new scrabbleFloat(sFloat - sInt);
        assertEquals(expectedRes3,scrFloat.subtract(sI));
        var expectedMul3 = new scrabbleFloat(sFloat * sInt);
        assertEquals(expectedMul3,scrFloat.multiply(sI));
        var expectedDiv3 = new scrabbleFloat(sFloat / sInt);
        assertEquals(expectedDiv3,scrFloat.divide(sI));
    }
}