package cl.uchile.dcc.scrabble.gui.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.gui.Controller.astController;
import cl.uchile.dcc.scrabble.gui.Controller.Factory.SIntFac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class controllerTest {

  @BeforeEach
  void setUp(){}

  @Test
  void TestController(){
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
}
