package cl.uchile.dcc.scrabble.gui;
/**
 * Interfaz de los tipos en Scrabble, contiene todas las transformaciones posibles para cada tipo,
 * si estas se pueden realizar a no depende de cada tipo. En caso de no ser un trasformacion valida
 * se retorna null.
 */
public interface SStrings {
  /** Sobreescribe el metodo toString de java, para poder visualizar los test. */
  @Override
  String toString();
  /** Transforma un tipo de Scrabble a un String de Scrabble. */
  scrabbleString toScrString();
}
