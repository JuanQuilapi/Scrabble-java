package cl.uchile.dcc.scrabble.gui.Factory;

import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleString;

import java.util.Hashtable;
/**
 * Fabrica de Strings de scrabble, implementa el patron Flyweight para no crear mas de una vez el
 * mismo String, para esto usa una tabla de Hash.
 */
public class SStringFac {
  private static final Hashtable<String, scrabbleString> hashtable0 = new Hashtable<>();
  /**
   * Revisa si el String se encuentra en la tabla de hash, de lo contrario lo crea y lo agrega a la
   * tabla.
   */
  public static scrabbleString make(String s) {
    scrabbleString scrS = hashtable0.get(s);
    if (scrS != null) {
      return scrS;
    } else {
      scrS = new scrabbleString(s);
      hashtable0.put(s, scrS);
    }
    return scrS;
  }
}
