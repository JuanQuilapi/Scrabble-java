package cl.uchile.dcc.scrabble.gui;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleBinaryTest {
    private final String sieteBin = "0111";
    private final String menosSieteBin = "1001";
    private final String veinteBin = "010100";
    private final String menosVeinteBin = "101100";
    private final String menosDoceBin = "11111111111111111111111111110100";
    private final String cincuentaYTresBin ="000000000000000000000110101";
    private scrabbleBinary[] binarios;
    @BeforeEach
    void setUp(){
        binarios = new scrabbleBinary[]{
        new scrabbleBinary(sieteBin),
        new scrabbleBinary(menosSieteBin),
        new scrabbleBinary(veinteBin),
        new scrabbleBinary(menosVeinteBin),
        new scrabbleBinary(menosDoceBin),
        new scrabbleBinary(cincuentaYTresBin)};
    }
    @Test
    void testConstructor(){
        var binsExpected = new scrabbleBinary[]{
            new scrabbleBinary(sieteBin),
            new scrabbleBinary(menosSieteBin),
            new scrabbleBinary(veinteBin),
            new scrabbleBinary(menosVeinteBin),
            new scrabbleBinary(menosDoceBin),
            new scrabbleBinary(cincuentaYTresBin)};
        for (int i =0;i < binsExpected.length;i++){
            assertEquals(binsExpected[i],binarios[i]);
            assertEquals(binsExpected[i].hashCode(),binarios[i].hashCode());
        }
        assertNotEquals(binsExpected[1],binarios[2]);
        assertNotEquals(binsExpected[3],binarios[4]);
        assertNotEquals(binsExpected[5],binarios[4]);
    }
    @Test
    void testToString() {
        var sBins = new String[]{
                sieteBin,
                menosSieteBin,
                veinteBin,
                menosVeinteBin,
                menosDoceBin,
                cincuentaYTresBin};
        for (int i =0;i < sBins.length;i++){
            assertEquals(sBins[i],binarios[i].toString());
        }
    }
    @Test
    void testToScrString() {
        var SSBins = new scrabbleString[]{
            new scrabbleString(sieteBin),
            new scrabbleString(menosSieteBin),
            new scrabbleString(veinteBin),
            new scrabbleString(menosVeinteBin),
            new scrabbleString(menosDoceBin),
            new scrabbleString(cincuentaYTresBin)};
        for (int i =0;i < SSBins.length;i++){
            assertEquals(SSBins[i],binarios[i].toScrString());
        }

    }
    @Test
    void testToScrFloat() {
        var SFBins = new scrabbleFloat[]{
            new scrabbleFloat(7.0),
            new scrabbleFloat(-7.0),
            new scrabbleFloat(20.0),
            new scrabbleFloat(-20.0),
            new scrabbleFloat(-12.0),
            new scrabbleFloat(53.0)};
        for (int i =0;i < SFBins.length;i++){
            assertEquals(SFBins[i],binarios[i].toScrFloat());
        }

    }
    @Test
    void testToScrInt() {
        var SIBins = new scrabbleInt[]{
            new scrabbleInt(7),
            new scrabbleInt(-7),
            new scrabbleInt(20),
            new scrabbleInt(-20),
            new scrabbleInt(-12),
            new scrabbleInt(53)};
        for(int i =0;i < SIBins.length;i++){
        assertEquals(SIBins[i],binarios[i].toScrInt());
    }

    }
    @Test
    void testToScrBin() {
        var BBins = new scrabbleBinary[]{
        new scrabbleBinary(sieteBin),
        new scrabbleBinary(menosSieteBin),
        new scrabbleBinary(veinteBin),
        new scrabbleBinary(menosVeinteBin),
        new scrabbleBinary(menosDoceBin),
        new scrabbleBinary(cincuentaYTresBin)};
        for (int i =0;i < BBins.length;i++){
            assertEquals(BBins[i],binarios[i].toScrBin());
        }
    }
    @RepeatedTest(20)
    void testAddSubtractMultiplyDivide(){
        int seed = new Random().nextInt();
        Random rng = new Random(seed);
        Double sFloat = rng.nextDouble()*10000;
        scrabbleFloat sF = new scrabbleFloat(sFloat);
        for (scrabbleBinary binario : binarios) {
            assertNull(binario.add(sF));
            assertNull(binario.subtract(sF));
            assertNull(binario.multiply(sF));
            assertNull(binario.divide(sF));
        }
        var RBins = new scrabbleBinary[]{
            new scrabbleBinary(cincuentaYTresBin),
            new scrabbleBinary(menosDoceBin),
            new scrabbleBinary(menosVeinteBin),
            new scrabbleBinary(sieteBin),
            new scrabbleBinary(veinteBin),
            new scrabbleBinary(menosSieteBin)};
        for (int i =0;i < binarios.length;i++) {
            scrabbleBinary expectedSum = new scrabbleInt(RBins[i].toScrInt().getsInt() +
                    binarios[i].toScrInt().getsInt()).toScrBin();
            assertEquals(expectedSum,binarios[i].add(RBins[i]));
            scrabbleBinary expectedRes = new scrabbleInt(binarios[i].toScrInt().getsInt() -
                    RBins[i].toScrInt().getsInt()).toScrBin();
            assertEquals(expectedRes, binarios[i].subtract(RBins[i]));
            scrabbleBinary expectedMul = new scrabbleInt(binarios[i].toScrInt().getsInt() *
                    RBins[i].toScrInt().getsInt()).toScrBin();
            assertEquals(expectedMul, binarios[i].multiply(RBins[i]));
            scrabbleBinary expectedDiv = new scrabbleInt(binarios[i].toScrInt().getsInt() /
                    RBins[i].toScrInt().getsInt()).toScrBin();
            assertEquals(expectedDiv, binarios[i].divide(RBins[i]));
        }
        int sInt = rng.nextInt(10000);
        scrabbleInt sI = new scrabbleInt(sInt);
        for (scrabbleBinary binario : binarios) {
            scrabbleBinary expectedSum2 = new scrabbleInt(binario.toScrInt().getsInt()+sInt).toScrBin();
            assertEquals(expectedSum2,binario.add(sI));
            scrabbleBinary expectedRes2 = new scrabbleInt(binario.toScrInt().getsInt() - sInt).toScrBin();
            assertEquals(expectedRes2, binario.subtract(sI));
            scrabbleBinary expectedMul2 = new scrabbleInt(binario.toScrInt().getsInt() * sInt).toScrBin();
            assertEquals(expectedMul2, binario.multiply(sI));
            scrabbleBinary expectedDiv2 = new scrabbleInt(binario.toScrInt().getsInt() / sInt).toScrBin();
            assertEquals(expectedDiv2, binario.divide(sI));
        }
    }
    @Test
    void testNeg(){
        var expectedBins = new scrabbleBinary[]{
                new scrabbleBinary("1000"),
                new scrabbleBinary("0110"),
                new scrabbleBinary("101011"),
                new scrabbleBinary("010011"),
                new scrabbleBinary("00000000000000000000000000001011"),
                new scrabbleBinary("111111111111111111111001010")
        };
        for(int i = 0;i<binarios.length;i++){
            assertEquals(expectedBins[i],binarios[i].neg());
            assertEquals(binarios[i],binarios[i].neg().neg());
        }
    }
    @Test
    void testAndOr(){
        scrabbleBoolean scrTrue = new scrabbleBoolean(true);
        scrabbleBoolean scrFalse = new scrabbleBoolean(false);
        for (scrabbleBinary binario : binarios) {
            assertEquals(binario, binario.and(scrTrue));
            assertEquals(binario,binario.or(scrFalse));
        }
        var expectedAndBins = new scrabbleBinary[]{
                new scrabbleBinary("0000"),
                new scrabbleBinary("0000"),
                new scrabbleBinary("000000"),
                new scrabbleBinary("000000"),
                new scrabbleBinary("00000000000000000000000000000000"),
                new scrabbleBinary("000000000000000000000000000")
        };
        var expectedOrBins = new scrabbleBinary[]{
                new scrabbleBinary("1111"),
                new scrabbleBinary("1111"),
                new scrabbleBinary("111111"),
                new scrabbleBinary("111111"),
                new scrabbleBinary("11111111111111111111111111111111"),
                new scrabbleBinary("111111111111111111111111111")
        };
        var RevBins = new scrabbleBinary[]{
                new scrabbleBinary(cincuentaYTresBin),
                new scrabbleBinary(menosDoceBin),
                new scrabbleBinary(menosVeinteBin),
                new scrabbleBinary(veinteBin),
                new scrabbleBinary(menosSieteBin),
                new scrabbleBinary(sieteBin)};
        var expectedAndBins2 = new scrabbleBinary[]{
                new scrabbleBinary("000000000000000000000000101"),
                new scrabbleBinary("11111111111111111111111111110000"),
                new scrabbleBinary("000100"),
                new scrabbleBinary("000100"),
                new scrabbleBinary("11111111111111111111111111110000"),
                new scrabbleBinary("000000000000000000000000101")
        };
        var expectedOrBins2 = new scrabbleBinary[]{
                new scrabbleBinary("000000000000000000000110111"),
                new scrabbleBinary("11111111111111111111111111111101"),
                new scrabbleBinary("111100"),
                new scrabbleBinary("111100"),
                new scrabbleBinary("11111111111111111111111111111101"),
                new scrabbleBinary("000000000000000000000110111")
        };
        for(int i = 0;i<binarios.length;i++){
            assertEquals(expectedAndBins[i],binarios[i].and(scrFalse));
            assertEquals(expectedAndBins2[i],binarios[i].and(RevBins[i]));
            assertEquals(expectedOrBins[i],binarios[i].or(scrTrue));
            assertEquals(expectedOrBins2[i],binarios[i].or(RevBins[i]));
        }
        }


}