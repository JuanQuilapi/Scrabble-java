package cl.uchile.dcc.scrabble.gui.Factory;

import cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles.scrabbleBoolean;

import java.util.Hashtable;
/**
 * Fabrica de Booleanos de scrabble, implementa el patron Flyweight para no crear mas de una vez el
 * mismo Boolean, para esto usa una tabla de Hash.
 */
public class SBoolFac {
  private static final Hashtable<Boolean, scrabbleBoolean> hashtable3 = new Hashtable<>();
  /**
   * Revisa si el booleano se encuentra en la tabla de hash, de lo contrario lo crea y lo agrega a
   * la tabla.
   */
  public static scrabbleBoolean make(Boolean b) {
    scrabbleBoolean scrBool = hashtable3.get(b);
    if (scrBool != null) {
      return scrBool;
    } else {
      scrBool = new scrabbleBoolean(b);
      hashtable3.put(b, scrBool);
    }
    return scrBool;
  }
}
