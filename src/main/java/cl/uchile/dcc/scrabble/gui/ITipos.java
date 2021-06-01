package cl.uchile.dcc.scrabble.gui;
/**
 * Interfaz de los tipos en Scrabble, contiene todas las transformaciones posibles para cada tipo, si estas se pueden
 * realizar a no depende de cada tipo. En caso de no ser un trasformacion valida se retorna null.
 */
public interface ITipos {
    @Override
    String toString();
    scrabbleString toScrString();
    scrabbleBoolean toScrBool();
    scrabbleBinary toScrBin();
    scrabbleInt toScrInt();
    scrabbleFloat toScrFloat();

}
