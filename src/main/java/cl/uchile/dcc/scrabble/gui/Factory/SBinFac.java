package cl.uchile.dcc.scrabble.gui.Factory;

import cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles.Numbers.scrabbleBinary;

import java.util.Hashtable;

/**
 * Fabrica de Binarios de scrabble, implementa el patron Flyweight para no crear mas de una vez el
 * mismo binario, para esto usa una tabla de Hash.
 */
public class SBinFac {
  private static final Hashtable<String, scrabbleBinary> hashtable4 = new Hashtable<>();

  /**
   * Revisa si el binario se encuentra en la tabla de hash, de lo contrario lo crea y lo agrega a la
   * tabla.
   */
  public static scrabbleBinary make(String b) {
    scrabbleBinary scrBin = hashtable4.get(b);
    if (scrBin != null) {
      return scrBin;
    } else {
      scrBin = new scrabbleBinary(b);
      hashtable4.put(b, scrBin);
    }
    return scrBin;
  }
}
