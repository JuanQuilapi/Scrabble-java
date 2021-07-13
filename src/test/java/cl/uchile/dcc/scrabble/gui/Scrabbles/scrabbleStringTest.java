package cl.uchile.dcc.scrabble.gui.Scrabbles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.gui.Scrabbles.*;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleBinary;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleFloat;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleInt;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleStringTest {
  private scrabbleString scrStr;
  private String str;
  private int seed;
  private Random rng;

  @BeforeEach
  void Setup() {
    seed = new Random().nextInt();
    rng = new Random(seed);
    int strSize = rng.nextInt(20);
    str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true, true, null, rng);
    scrStr = new scrabbleString(str);
  }

  @RepeatedTest(20)
  void testConstructor() {
    var expectedScrabble = new scrabbleString(str);
    assertEquals(expectedScrabble, scrStr);
    assertEquals(expectedScrabble.hashCode(), scrStr.hashCode());
    String differentStr;
    do {
      differentStr =
          RandomStringUtils.random(
              rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentStr.equals(str));
    var differentScrabble = new scrabbleString(differentStr);
    assertNotEquals(differentScrabble, scrStr);
  }

  @RepeatedTest(20)
  void testToString() {
    assertEquals(str, scrStr.toString());
  }

  @RepeatedTest(20)
  void testToScrString() {
    var expectedScrStr = new scrabbleString(str);
    assertEquals(expectedScrStr, scrStr.toScrString());
  }

  @RepeatedTest(20)
  void testAdd() {
    String differentStr;
    do {
      differentStr =
          RandomStringUtils.random(
              rng.nextInt(20), 0, Character.MAX_CODE_POINT, true, true, null, rng);
    } while (differentStr.equals(str));
    var scrStr2 = new scrabbleString(differentStr);
    var expectedScrString = new scrabbleString(str + differentStr);
    var expectedScrString2 = new scrabbleString(differentStr + str);
    assertEquals(expectedScrString, scrStr.add(scrStr2));
    assertEquals(expectedScrString2, scrStr2.add(scrStr));
    scrabbleBoolean scrTrue = new scrabbleBoolean(true);
    scrabbleBoolean scrFalse = new scrabbleBoolean(false);
    var expectedScrString3 = new scrabbleString(str + true);
    var expectedScrString4 = new scrabbleString(str + false);
    assertEquals(expectedScrString3, scrStr.add(scrTrue));
    assertEquals(expectedScrString4, scrStr.add(scrFalse));
    Integer sInt = rng.nextInt(10000);
    scrabbleInt scrInt = new scrabbleInt(sInt);
    var expectedScrString5 = new scrabbleString(str + sInt);
    assertEquals(expectedScrString5, scrStr.add(scrInt));
    Double sFloat = rng.nextDouble() * 10000;
    scrabbleFloat scrFloat = new scrabbleFloat(sFloat);
    var expectedScrString6 = new scrabbleString(str + sFloat);
    assertEquals(expectedScrString6, scrStr.add(scrFloat));
    scrabbleBinary scrBin = scrInt.toScrBin();
    var expectedScrString7 = new scrabbleString(str + scrBin.toString());
    assertEquals(expectedScrString7, scrStr.add(scrBin));
  }
}
