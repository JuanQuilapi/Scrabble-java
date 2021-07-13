package cl.uchile.dcc.scrabble.gui.operaciones;

import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.*;

import cl.uchile.dcc.scrabble.gui.Scrabbles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class astTest {
    private Double f;
    private int i;
    private scrabbleFloat scrFloat;
    private scrabbleInt scrInt;
    private final String bin = "0101";
    private scrabbleBinary scrBin;
    private scrabbleBinary scrBin2;
    private int seed;
    private Random rng;

    @BeforeEach
    void Setup(){
        seed = new Random().nextInt();
        f = rng.nextDouble() * 10000;
        i = rng.nextInt(10000);
        scrFloat = new scrabbleFloat(f);
        scrInt = new scrabbleInt(i);
        scrBin = new scrabbleBinary(bin);
        scrBin2 = new scrabbleBinary("011");
    }

    @Test
    void testArbol(){
        var ast = new Add(
                new Constant(scrBin),
                new ToInt(
                        new Constant(scrBin2))
        );
        var binExp = new scrabbleBinary("01000");
        assertEquals(binExp,ast.eval());

        var ast2 = new Add(
                new Constant(scrFloat),ast
        );
        var floatExpected = new scrabbleFloat(11.0);
        assertEquals(floatExpected,ast2.eval());

        var ast2inv = new Add(ast,new Constant(scrFloat));
        assertNull(ast2inv.eval());

        var ast3 = new Add(
                new Constant(new scrabbleFloat(6.9)),
                new Or(
                        new Constant(new scrabbleBinary("1000")),
                        new ToBin(new Sub(
                                new Constant(new scrabbleInt(25)),
                                new Constant(new scrabbleBinary("0101"))
                        ))

                )
        );
        var floatExpected2 = new scrabbleFloat(6.9).add(
                new scrabbleBinary("1000").or(
                new scrabbleInt(25).
                        subtract(new scrabbleBinary("0101")).toScrBin()));
        assertEquals(floatExpected2,ast3.eval());

    }
}