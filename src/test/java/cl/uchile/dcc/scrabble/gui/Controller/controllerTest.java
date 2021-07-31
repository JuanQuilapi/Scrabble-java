package cl.uchile.dcc.scrabble.gui.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.gui.Controller.Factory.*;

import cl.uchile.dcc.scrabble.gui.Modelo.Numbers.scrabbleBinary;
import cl.uchile.dcc.scrabble.gui.Modelo.Numbers.scrabbleFloat;
import cl.uchile.dcc.scrabble.gui.Modelo.Numbers.scrabbleInt;
import cl.uchile.dcc.scrabble.gui.Modelo.scrabbleString;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class controllerTest {
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
  void setUp(){
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

  @Test
  void TestController1(){
    astController.AddOpScr("Add");
    astController.AddConst("Entero","10");
    astController.AddConst("Entero","2");
    var expInt = SIntFac.make(12);
    assertEquals(expInt,astController.getResultado());
    astController.reset();
    astController.AddOpScr("Add");
    astController.AddConst("Entero","10");
    astController.AddOpScr("Add");
    astController.AddOpScr("Null");
    astController.AddOpScr("Null");
    astController.AddConst("Entero","2");
    astController.AddConst("Entero","15");
    var expInt2 = SIntFac.make(27);
    assertEquals(expInt2,astController.getResultado());
    astController.reset();
  }

  @RepeatedTest(20)
  void testControllerNums(){
  astController.AddOpScr("Add");
  astController.AddConst("Binario",scrBin.toString());
  astController.AddOpScr("ToInt");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddConst("Binario",scrBin2.toString());
  var binExp = scrBin.add(scrBin2.toScrInt());
  var ast = astController.getResultado();
  assertEquals(binExp,ast);
  astController.reset();

  astController.AddOpScr("Div");
  astController.AddOpScr("Add");
  astController.AddOpScr("ToFloat");
  astController.AddConst("Decimal",scrFloat.toString());
  astController.AddConst("Binario",ast.toString());
  astController.AddOpScr("Mult");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddConst("Entero",scrInt.toString());
  astController.AddOpScr("ToBin");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddConst("Entero",SIntFac.make(-5).toString());
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  astController.AddOpScr("Null");
  var floatExpected = scrFloat.add(ast).divide(scrInt.toScrFloat().multiply(SIntFac.make(-5).toScrBin()));
  assertEquals(floatExpected,astController.getResultado());
  astController.reset();
  }
  @Test
  void testController2(){
   astController.AddOpScr("Add");
   astController.AddConst("Decimal","6.9");
   astController.AddOpScr("Or");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddConst("Binario","1000");
   astController.AddOpScr("ToBin");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Sub");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");
   astController.AddConst("Entero","25");
   astController.AddConst("Binario","0101");
   astController.AddOpScr("Null");
   astController.AddOpScr("Null");

    var floatExpected2 = SFloatFac.make(6.9).add(
        SBinFac.make("1000").or(
            SIntFac.make(25).
                subtract(SBinFac.make("0101")).toScrBin()));
    assertEquals(floatExpected2,astController.getResultado());
    astController.reset();

    astController.AddOpScr("Add");
    astController.AddConst("String",scrStr.toString());
    astController.AddOpScr("Add");
    astController.AddOpScr("Null");
    astController.AddOpScr("Null");
    astController.AddOpScr("ToStr");
    astController.AddOpScr("Add");
    for (int i = 0;i<4;i++){
      astController.AddOpScr("Null");
    }
    astController.AddOpScr("ToBool");
    astController.AddOpScr("Null");
    astController.AddConst("String","Hola");
    astController.AddOpScr("And");
    for (int i = 0;i<8;i++){
      astController.AddOpScr("Null");
    }
    astController.AddConst("Booleano","false");
    for (int i = 0;i<5;i++){
      astController.AddOpScr("Null");
    }
    astController.AddOpScr("Neg");
    astController.AddConst("Binario", "0101010101");
    for (int i = 0;i<28;i++){
      astController.AddOpScr("Null");
    }
    astController.AddConst("Booleano","true");
    astController.AddOpScr("Null");
    astController.AddOpScr("Null");
    astController.AddOpScr("Null");
    var stringExp = SStringFac.make("HolafalseHola0000000000");
    assertEquals(stringExp,astController.getResultado());
    astController.reset();

  }
}
