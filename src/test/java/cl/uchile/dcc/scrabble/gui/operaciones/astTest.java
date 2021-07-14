package cl.uchile.dcc.scrabble.gui.operaciones;

import cl.uchile.dcc.scrabble.gui.Factory.*;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.*;

import cl.uchile.dcc.scrabble.gui.Scrabbles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class astTest {
    private Double f;
    private int i;
    private scrabbleFloat scrFloat;
    private scrabbleInt scrInt;
    private final String bin = "0101";
    private scrabbleBinary scrBin;
    private scrabbleBinary scrBin2;
    private scrabbleString scrStr;
    private int seed;
    private Random rng;

    @BeforeEach
    void Setup(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        f = rng.nextDouble() * 10000;
        i = rng.nextInt(10000);
        scrFloat = SFloatFac.make(f);
        scrInt = SIntFac.make(i);
        scrBin = SBinFac.make(bin);
        scrBin2 = SBinFac.make("011");
        scrStr = SStringFac.make("Hola");
    }

    @RepeatedTest(20)
    void testArboles1nums(){
        var ast = new Add(
                new Constant(scrBin),
                new ToInt(
                        new Constant(scrBin2))
        );
        var binExp = scrBin.add(scrBin2.toScrInt());
        assertEquals(binExp,ast.eval());

        var ast2 = new Div(new Add(
                        new Constant(scrFloat),ast),new ToFloat(new Mult(
                            new Constant(scrInt), new ToBin(new Constant(SIntFac.make(-5))))
        ));

        var floatExpected = scrFloat.add(ast.eval()).divide(scrInt.multiply(SIntFac.make(-5).toScrBin()));
        assertEquals(floatExpected,ast2.eval());

        var ast2inv = new Add(ast,new Constant(scrFloat));
        assertNull(ast2inv.eval());


    }

    @Test
    void testArboles2(){
        var ast = new Add(
                new Constant(SFloatFac.make(6.9)),
                new Or(
                        new Constant(SBinFac.make("1000")),
                        new ToBin(new Sub(
                                new Constant(SIntFac.make(25)),
                                new Constant(SBinFac.make("0101"))
                        ))

                )
        );
        var floatExpected2 = SFloatFac.make(6.9).add(
                SBinFac.make("1000").or(
                        SIntFac.make(25).
                                subtract(SBinFac.make("0101")).toScrBin()));
        assertEquals(floatExpected2,ast.eval());

        var ast2 = new Add(
                new Constant(scrStr),new Add(
                    new ToStr(new ToBool(new Constant(SBoolFac.make(false)))),new Add(
                        new Constant(SStringFac.make("Hola")),new And(
                            new Neg(new Constant(SBoolFac.make(true))),
                            new Constant(SBinFac.make("0101010101")))
        )));
        var stringExp = SStringFac.make("HolafalseHola0000000000");
        assertEquals(stringExp,ast2.eval());

    }
    @RepeatedTest(20)
    void testNull(){
        scrabbleBoolean scrBool = SBoolFac.make(false);
        assertNull(scrBin.toScrBool());
        assertNull(SBoolFac.make(true).multiply(scrInt));
        assertNull(scrBool.multiplyInt(scrInt));
        assertNull(scrStr.multiplyBin(scrBin));
        assertNull(scrStr.multiplyFloat(scrFloat));
        assertNull(scrBool.divide(scrFloat));
        assertNull(scrBool.divideFloat(scrFloat));
        assertNull(scrStr.divideInt(scrInt));
        assertNull(scrStr.divideBin(scrBin));
        assertNull(scrStr.subtract(scrBool));
        assertNull(scrStr.subtractInt(scrInt));
        assertNull(scrBool.subtractFloat(scrFloat));
        assertNull(scrBool.subtractBin(scrBin));
        assertNull(scrBool.toScrBin());
        assertNull(scrBool.toScrFloat());
        assertNull(scrBool.toScrInt());
        assertNull(scrInt.neg());
        assertNull(scrBool.add(scrInt));
        assertNull(scrBool.addInt(scrInt));
        assertNull(scrBool.addBin(scrBin2));
        assertNull(scrBool.addFloat(scrFloat));
        assertNull(scrInt.and(scrFloat));
        assertNull(scrInt.andBinary(scrBin));
        assertNull(scrFloat.andBool(scrBool));
        assertNull(scrFloat.or(scrStr));
        assertNull(scrStr.orBinary(scrBin2));
        assertNull(scrStr.orBool(scrBool));
        }
}