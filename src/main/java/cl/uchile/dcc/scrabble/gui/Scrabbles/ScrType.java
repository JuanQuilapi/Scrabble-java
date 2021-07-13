package cl.uchile.dcc.scrabble.gui.Scrabbles;

import cl.uchile.dcc.scrabble.gui.operaciones.Hojas;

/**
 * Interfaz de los tipos en Scrabble, contiene todas las transformaciones posibles para cada tipo,
 * si estas se pueden realizar a no depende de cada tipo. En caso de no ser un trasformacion valida
 * se retorna null.
 */
public interface ScrType extends Hojas {
  /** Sobreescribe el metodo toString de java, para poder visualizar los test. */
  @Override
  String toString();
  /** Transforma un tipo de Scrabble a un String de Scrabble. */
  @Override
  scrabbleString toScrString();

}
