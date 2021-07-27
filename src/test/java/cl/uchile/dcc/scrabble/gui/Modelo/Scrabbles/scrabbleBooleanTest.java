package cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles;

import cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles.Numbers.scrabbleBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleBooleanTest {
  Boolean bTrue = true;
  Boolean bFalse = false;
  private scrabbleBoolean scrTrue;
  private scrabbleBoolean scrFalse;

  @BeforeEach
  void Setup() {
    scrTrue = new scrabbleBoolean(true);
    scrFalse = new scrabbleBoolean(false);
  }

  @Test
  void testConstructor() {
    var expectedScrabble = new scrabbleBoolean(true);
    assertEquals(expectedScrabble, scrTrue);
    assertEquals(expectedScrabble.hashCode(), scrTrue.hashCode());
    assertNotEquals(scrTrue, scrFalse);
  }

  @Test
  void testToString() {
    assertEquals(bTrue.toString(), scrTrue.toString());
    assertNotEquals(bFalse.toString(), scrTrue.toString());
    assertEquals(bFalse.toString(), scrFalse.toString());
  }

  @Test
  void testToScrString() {
    var expectedScrStr = new scrabbleString(bTrue.toString());
    assertEquals(expectedScrStr, scrTrue.toScrString());
    var expectedScrStr2 = new scrabbleString(bFalse.toString());
    assertNotEquals(expectedScrStr2, scrTrue.toScrString());
    assertEquals(expectedScrStr2, scrFalse.toScrString());
  }

  @Test
  void testToScrBool() {
    var expectedScrBool = new scrabbleBoolean(bTrue);
    assertEquals(expectedScrBool, scrTrue.toScrBool());
    var expectedScrBool2 = new scrabbleBoolean(bFalse);
    assertNotEquals(expectedScrBool2, scrTrue.toScrBool());
    assertEquals(expectedScrBool2, scrFalse.toScrBool());
  }

  @Test
  void testNeg() {
    var expectedScrBool = new scrabbleBoolean(bFalse);
    assertEquals(expectedScrBool, scrTrue.neg());
    var expectedScrBool2 = new scrabbleBoolean(bTrue);
    assertEquals(expectedScrBool2, scrTrue.neg().neg());
    assertEquals(expectedScrBool2, scrFalse.neg());
  }

  @Test
  void testAndOr() {
    var expectedBool = new scrabbleBoolean(bTrue);
    var expectedBool2 = new scrabbleBoolean(bFalse);
    assertEquals(expectedBool, scrTrue.and(new scrabbleBoolean(true)));
    assertEquals(expectedBool2, scrTrue.and(scrFalse));
    assertEquals(expectedBool, scrTrue.or(new scrabbleBoolean(true)));
    assertEquals(expectedBool, scrTrue.or(scrFalse));
    assertEquals(expectedBool, scrFalse.or(scrTrue));
    assertEquals(expectedBool2, scrFalse.or(new scrabbleBoolean(false)));
    String menosVeinteBin = "101100";
    String cincuentaYTresBin = "00000110101";
    String menosDoceBin = "11111111111110100";
    String veinteBin = "010100";
    String menosSieteBin = "1001";
    String sieteBin = "0111";
    var binarios =
        new scrabbleBinary[] {
          new scrabbleBinary(sieteBin),
          new scrabbleBinary(menosSieteBin),
          new scrabbleBinary(veinteBin),
          new scrabbleBinary(menosVeinteBin),
          new scrabbleBinary(menosDoceBin),
          new scrabbleBinary(cincuentaYTresBin)
        };
    for (scrabbleBinary binario : binarios) {
      assertEquals(binario, scrTrue.and(binario));
      assertEquals(binario, scrFalse.or(binario));
    }
    var expectedAndBins =
        new scrabbleBinary[] {
          new scrabbleBinary("0000"),
          new scrabbleBinary("0000"),
          new scrabbleBinary("000000"),
          new scrabbleBinary("000000"),
          new scrabbleBinary("00000000000000000"),
          new scrabbleBinary("00000000000")
        };
    var expectedOrBins =
        new scrabbleBinary[] {
          new scrabbleBinary("1111"),
          new scrabbleBinary("1111"),
          new scrabbleBinary("111111"),
          new scrabbleBinary("111111"),
          new scrabbleBinary("11111111111111111"),
          new scrabbleBinary("11111111111")
        };
    for (int i = 0; i < binarios.length; i++) {
      assertEquals(expectedAndBins[i], scrFalse.and(binarios[i]));
      assertEquals(expectedOrBins[i], scrTrue.or(binarios[i]));
    }
  }
}
