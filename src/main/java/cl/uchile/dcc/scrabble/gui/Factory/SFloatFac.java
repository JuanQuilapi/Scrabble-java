package cl.uchile.dcc.scrabble.gui.Factory;

import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleFloat;

import java.util.Hashtable;
/**
 * Fabrica de Decimal de scrabble, implementa el patron Flyweight para no crear mas de una vez el
 * mismo decimal, para esto usa una tabla de Hash.
 */
public class SFloatFac {
  private static final Hashtable<Double, scrabbleFloat> hashtable2 = new Hashtable<>();
  /**
   * Revisa si el decimal se encuentra en la tabla de hash, de lo contrario lo crea y lo agrega a la
   * tabla.
   */
  public static scrabbleFloat make(Double f) {
    scrabbleFloat scrF = hashtable2.get(f);
    if (scrF != null) {
      return scrF;
    } else {
      scrF = new scrabbleFloat(f);
      hashtable2.put(f, scrF);
    }
    return scrF;
  }
}
