package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleStringTest {
    private scrabbleString scrStr;
    private  String str;
    private int seed;
    private Random rng;
    @BeforeEach
    void Setup() {
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize = rng.nextInt(20);
        str = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true,true,null,rng);
        scrStr = new scrabbleString(str);
    }
    @RepeatedTest(20)
    void testConstructor() {
        var expectedScrabble = new scrabbleString(str);
        assertEquals(expectedScrabble,scrStr);
        assertEquals(expectedScrabble.hashCode(),scrStr.hashCode());
        String differentStr;
        do {
            differentStr = RandomStringUtils.random(rng.nextInt(20), 0, Character.MAX_CODE_POINT, true,true,null,rng);
        }while (differentStr.equals(str));
        var differentScrabble = new scrabbleString(differentStr);
        assertNotEquals(differentScrabble,scrStr);
    }

    @RepeatedTest(20)
    void testToString(){
        assertEquals(str,scrStr.toString());
    }

    @RepeatedTest(20)
    void testToScrString(){
        var expectedScrStr = new scrabbleString(str);
        assertEquals(expectedScrStr,scrStr.toScrString());
    }
    @RepeatedTest(20)
    void testToScrBool(){
        assertNull(scrStr.toScrBool());
    }

    @RepeatedTest(20)
    void testToScrFloat() {
        assertNull(scrStr.toScrFloat());
    }

    @RepeatedTest(20)
    void testScrToScrInt() {
        assertNull(scrStr.toScrInt());
    }
    @RepeatedTest(20)
    void testToScrBin(){
        assertNull(scrStr.toScrBin());
    }
}