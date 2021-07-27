package cl.uchile.dcc.scrabble.gui.operaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.gui.Factory.SIntFac;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class controllerTest {

  @BeforeEach
  void setUp(){}
  @Test
  void Test1(){
    var copa =  new Add();

      var nodo1= new Sub();
        var nodo11 = new Constant();
          nodo11.setAddend1(SIntFac.make(10));
        nodo1.setAddend1(nodo11);
    var nodo12 = new Constant();
          nodo12.setAddend1(SIntFac.make(2));
        nodo1.setAddend2(nodo12);
      copa.setAddend1(nodo1);
      var nodo2 = new Constant();
        nodo2.setAddend1(SIntFac.make(5));
      copa.setAddend2(nodo2);

      var expInt = SIntFac.make(13);
    assertEquals(expInt,copa.eval());
  }

}
