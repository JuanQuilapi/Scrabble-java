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
    private final String sieteBin = "0111";
    private final String menosSieteBin = "1001";
    private final String veinteBin = "010100";
    private final String menosVeinteBin = "101100";

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
        String menosDoceBin = "10100";
        String cincuentaYTresBin = "0110101";
        var expectedBins = new scrabbleBinary[]{
            new scrabbleBinary(sieteBin),
            new scrabbleBinary(menosSieteBin),
            new scrabbleBinary(veinteBin),
            new scrabbleBinary(menosVeinteBin),
            new scrabbleBinary(menosDoceBin),
            new scrabbleBinary(cincuentaYTresBin)};
        var SInts = new scrabbleInt[]{
            new scrabbleInt(7),
            new scrabbleInt(-7),
            new scrabbleInt(20),
            new scrabbleInt(-20),
            new scrabbleInt(-12),
            new scrabbleInt(53)};
        for(int i = 0;i<SInts.length;i++){
            assertEquals(expectedBins[i],SInts[i].toScrBin());
        }
    }
    @RepeatedTest(20)
    void testAddSubtractMultiplyDivide(){
        Double sFloat = rng.nextDouble()*10000;
        scrabbleFloat sF = new scrabbleFloat(sFloat);
        var expectedSum = new scrabbleFloat(sInt+sFloat);
        assertEquals(expectedSum,scrInt.add(sF));
        var expectedRes = new scrabbleFloat(sInt - sFloat);
        assertEquals(expectedRes,scrInt.subtract(sF));
        var expectedMul = new scrabbleFloat(sInt * sFloat);
        assertEquals(expectedMul,scrInt.multiply(sF));
        var expectedDiv = new scrabbleFloat(sInt / sFloat);
        assertEquals(expectedDiv,scrInt.divide(sF));
        var SBins = new scrabbleBinary[]{
                new scrabbleBinary(sieteBin),
                new scrabbleBinary(menosSieteBin),
                new scrabbleBinary(veinteBin),
                new scrabbleBinary(menosVeinteBin),
                new scrabbleBinary("1111110100"),//-12 con mas unos al final
                new scrabbleBinary("00000000110101")};//53 con mas ceros al inicio
        for (scrabbleBinary sBin : SBins) {
            var expectedSum2 = new scrabbleInt(sBin.toScrInt().getsInt() + sInt);
            assertEquals(expectedSum2, scrInt.add(sBin));
            var expectedRes2 = new scrabbleInt(sInt - sBin.toScrInt().getsInt());
            assertEquals(expectedRes2, scrInt.subtract(sBin));
            var expectedMul2 = new scrabbleInt(sInt * sBin.toScrInt().getsInt());
            assertEquals(expectedMul2, scrInt.multiply(sBin));
            var expectedDiv2 = new scrabbleInt(sInt / sBin.toScrInt().getsInt());
            assertEquals(expectedDiv2, scrInt.divide(sBin));
        }
        Integer differentInt;
        do {
            differentInt = rng.nextInt(10000);
        }while (differentInt.equals(sInt));
        scrabbleInt sInt2 = new scrabbleInt(differentInt);
        var expectedSum3 = new scrabbleInt(sInt + differentInt);
        assertEquals(expectedSum3,scrInt.add(sInt2));
        var expectedRes3 = new scrabbleInt(sInt - differentInt);
        assertEquals(expectedRes3,scrInt.subtract(sInt2));
        var expectedMul3 = new scrabbleInt(sInt * differentInt);
        assertEquals(expectedMul3,scrInt.multiply(sInt2));
        var expectedDiv3 = new scrabbleInt(sInt / differentInt);
        assertEquals(expectedDiv3,scrInt.divide(sInt2));
    }
}