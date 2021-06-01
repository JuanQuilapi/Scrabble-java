package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleBinaryTest {
    private final String sieteBin = "0111";
    private final String menosSieteBin = "1001";
    private final String veinteBin = "010100";
    private final String menosVeinteBin = "101100";
    private final String menosDoceBin = "11111111111111111111111111110100";
    private final String cincuentaYTresBin ="000000000000000000000110101";
    private scrabbleBinary sBin7;
    private scrabbleBinary sBinMenos7;
    private scrabbleBinary sBin20;
    private scrabbleBinary sBinMenos20;
    private scrabbleBinary sBinMenos12;
    private scrabbleBinary sBin53;
    @BeforeEach
    void setUp(){
        sBin7 = new scrabbleBinary(sieteBin);
        sBinMenos7 = new scrabbleBinary(menosSieteBin);
        sBin20 = new scrabbleBinary(veinteBin);
        sBinMenos20 = new scrabbleBinary(menosVeinteBin);
        sBinMenos12 = new scrabbleBinary(menosDoceBin);
        sBin53 = new scrabbleBinary(cincuentaYTresBin);
    }
    @Test
    void testConstructor(){
        var binExpected = new scrabbleBinary(sieteBin);
        var binExpected2 = new scrabbleBinary(menosSieteBin);
        var binExpected3 = new scrabbleBinary(veinteBin);
        var binExpected4 = new scrabbleBinary(menosVeinteBin);
        var binExpected5 = new scrabbleBinary(menosDoceBin);
        var binExpected6 = new scrabbleBinary(cincuentaYTresBin);
        assertEquals(binExpected,sBin7);
        assertEquals(binExpected2,sBinMenos7);
        assertNotEquals(binExpected,sBinMenos7);
        assertEquals(binExpected3,sBin20);
        assertNotEquals(binExpected4,sBin20);
        assertEquals(binExpected4,sBinMenos20);
        assertEquals(binExpected5,sBinMenos12);
        assertNotEquals(binExpected6,sBinMenos12);
        assertEquals(binExpected6,sBin53);
    }
    @Test
    void testToString() {
        assertEquals(sieteBin,sBin7.toString());
        assertEquals(menosSieteBin,sBinMenos7.toString());
        assertEquals(veinteBin,sBin20.toString());
        assertEquals(menosVeinteBin,sBinMenos20.toString());
        assertEquals(menosDoceBin,sBinMenos12.toString());
        assertEquals(cincuentaYTresBin,sBin53.toString());
    }
    @Test
    void testToScrString() {
        var scrStringExpected = new scrabbleString(sieteBin);
        var scrStringExpected2 = new scrabbleString(menosSieteBin);
        var scrStringExpected3 = new scrabbleString(veinteBin);
        var scrStringExpected4 = new scrabbleString(menosVeinteBin);
        var scrStringExpected5 = new scrabbleString(menosDoceBin);
        var scrStringExpected6 = new scrabbleString(cincuentaYTresBin);
        assertEquals(scrStringExpected,sBin7.toScrString());
        assertEquals(scrStringExpected2,sBinMenos7.toScrString());
        assertEquals(scrStringExpected3,sBin20.toScrString());
        assertEquals(scrStringExpected4,sBinMenos20.toScrString());
        assertEquals(scrStringExpected5,sBinMenos12.toScrString());
        assertEquals(scrStringExpected6,sBin53.toScrString());
    }
    @Test
    void testToScrBool() {
        assertNull(sBin7.toScrBool());
        assertNull(sBinMenos7.toScrBool());
        assertNull(sBin20.toScrBool());
        assertNull(sBinMenos20.toScrBool());
        assertNull(sBinMenos12.toScrBool());
        assertNull(sBin53.toScrBool());
    }
    @Test
    void testToScrFloat() {
        var scrFloatExpected = new scrabbleFloat(7.0);
        var scrFloatExpected2 = new scrabbleFloat(-7.0);
        var scrFloatExpected3 = new scrabbleFloat(20.0);
        var scrFloatExpected4 = new scrabbleFloat(-20.0);
        var scrFloatExpected5 = new scrabbleFloat(-12.0);
        var scrFloatExpected6 = new scrabbleFloat(53.0);
        assertEquals(scrFloatExpected,sBin7.toScrFloat());
        assertEquals(scrFloatExpected2,sBinMenos7.toScrFloat());
        assertEquals(scrFloatExpected3,sBin20.toScrFloat());
        assertEquals(scrFloatExpected4,sBinMenos20.toScrFloat());
        assertEquals(scrFloatExpected5,sBinMenos12.toScrFloat());
        assertEquals(scrFloatExpected6,sBin53.toScrFloat());
    }
    @Test
    void testToScrInt() {
        var scrIntExpected = new scrabbleInt(7);
        var scrIntExpected2 = new scrabbleInt(-7);
        var scrIntExpected3 = new scrabbleInt(20);
        var scrIntExpected4 = new scrabbleInt(-20);
        var scrIntExpected5 = new scrabbleInt(-12);
        var scrIntExpected6 = new scrabbleInt(53);
        assertEquals(scrIntExpected,sBin7.toScrInt());
        assertEquals(scrIntExpected2,sBinMenos7.toScrInt());
        assertEquals(scrIntExpected3,sBin20.toScrInt());
        assertEquals(scrIntExpected4,sBinMenos20.toScrInt());
        assertEquals(scrIntExpected5,sBinMenos12.toScrInt());
        assertEquals(scrIntExpected6,sBin53.toScrInt());
    }
    @Test
    void testToScrBin() {
        var binExpected = new scrabbleBinary(sieteBin);
        var binExpected2 = new scrabbleBinary(menosSieteBin);
        var binExpected3 = new scrabbleBinary(veinteBin);
        var binExpected4 = new scrabbleBinary(menosVeinteBin);
        var binExpected5 = new scrabbleBinary(menosDoceBin);
        var binExpected6 = new scrabbleBinary(cincuentaYTresBin);
        assertEquals(binExpected,sBin7.toScrBin());
        assertEquals(binExpected2,sBinMenos7.toScrBin());
        assertEquals(binExpected3,sBin20.toScrBin());
        assertEquals(binExpected4,sBinMenos20.toScrBin());
        assertEquals(binExpected5,sBinMenos12.toScrBin());
        assertEquals(binExpected6,sBin53.toScrBin());
    }
}