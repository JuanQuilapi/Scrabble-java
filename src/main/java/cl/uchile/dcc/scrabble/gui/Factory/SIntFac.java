package cl.uchile.dcc.scrabble.gui.Factory;

import cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles.Numbers.scrabbleInt;

import java.util.Hashtable;
/**
 * Fabrica de Enteros de scrabble, implementa el patron Flyweight para no crear mas de una vez el
 * mismo Entero, para esto usa una tabla de Hash.
 */
public class SIntFac {
  private static final Hashtable<Integer, scrabbleInt> hashtable1 = new Hashtable<>();
  /**
   * Revisa si el Entero se encuentra en la tabla de hash, de lo contrario lo crea y lo agrega a la
   * tabla.
   */
  public static scrabbleInt make(Integer i) {
    scrabbleInt scrI = hashtable1.get(i);
    if (scrI != null) {
      return scrI;
    } else {
      scrI = new scrabbleInt(i);
      hashtable1.put(i, scrI);
    }
    return scrI;
  }
}
