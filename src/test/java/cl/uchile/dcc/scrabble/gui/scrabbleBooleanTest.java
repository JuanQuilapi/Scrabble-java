package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class scrabbleBooleanTest {
    private scrabbleBoolean scrBool;
    private  Boolean bool;
    @BeforeEach
    void Setup() {
        bool = true;
        scrBool = new scrabbleBoolean(bool);
    }
    @Test
    void testConstructor() {
        var expectedScrabble = new scrabbleBoolean(bool);
        assertEquals(expectedScrabble, scrBool);
        assertEquals(expectedScrabble.hashCode(), scrBool.hashCode());
        var differentScrabble = new scrabbleBoolean(!bool);
        assertNotEquals(differentScrabble,scrBool);
    }
    @Test
    void testToString(){
        assertEquals(bool.toString(),scrBool.toString());
        boolean notBoll = !bool;
        assertNotEquals(Boolean.toString(notBoll),scrBool.toString());
    }
    @Test
    void testToScrString(){
        var expectedScrStr = new scrabbleString(bool.toString());
        assertEquals(expectedScrStr,scrBool.toScrString());
        boolean notBoll = !bool;
        var expectedScrStr2 = new scrabbleString(Boolean.toString(notBoll));
        assertNotEquals(expectedScrStr2,scrBool.toScrString());
    }
    @Test
    void testToScrBool(){
        var expectedScrBool = new scrabbleBoolean(bool);
        assertEquals(expectedScrBool,scrBool.toScrBool());
        boolean notBoll = !bool;
        var expectedScrBool2 = new scrabbleBoolean(notBoll);
        assertNotEquals(expectedScrBool2,scrBool.toScrBool());
    }
    @Test
    void testToScrFloat() {
        assertNull(scrBool.toScrFloat());
        boolean notBoll = !bool;
        var ScrBool2 = new scrabbleBoolean(notBoll);
        assertNull(ScrBool2.toScrFloat());
    }
    @Test
    void testToScrInt(){
        assertNull(scrBool.toScrInt());
        boolean notBoll = !bool;
        var ScrBool2 = new scrabbleBoolean(notBoll);
        assertNull(ScrBool2.toScrInt());
    }
    @Test
    void testToScrBin(){
        assertNull(scrBool.toScrBin());
        boolean notBoll = !bool;
        var ScrBool2 = new scrabbleBoolean(notBoll);
        assertNull(ScrBool2.toScrBin());
    }
}