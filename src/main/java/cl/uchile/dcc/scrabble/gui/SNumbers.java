package cl.uchile.dcc.scrabble.gui;

public interface SNumbers {
  /**
   * Transforma un numero de Scrabble(CLase que implemente la interfaz) a un Binario de Scrabble.
   */
  scrabbleBinary toScrBin();
  /** Transforma un numero de Scrabble(clase que implemente la interfaz) a un Entero de Scrabble. */
  scrabbleInt toScrInt();
  /**
   * Transforma un numero de Scrabble(clase que implemente la interfaz) a un decimal de Scrabble.
   */
  scrabbleFloat toScrFloat();
  /**
   * Devuelve como es la suma entre un numero de Scrabble al ser sumado con un entero de Scrabble.
   */
  SNumbers addInt(scrabbleInt sI);
  /**
   * Devuelve como es la suma entre un numero de Scrabble al ser sumado con un decimal de Scrabble.
   */
  SNumbers addFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la suma entre un numero de Scrabble al ser sumado con un binario de Scrabble.
   */
  SNumbers addBin(scrabbleBinary sB);
  /** Devuelve como es la suma entre dos numero de Scrabble. */
  SNumbers add(SNumbers s);
  /**
   * Devuelve como es la resta entre un numero de Scrabble al ser sustraido a un entero de Scrabble.
   */
  SNumbers subtractInt(scrabbleInt sI);
  /**
   * Devuelve como es la resta entre un numero de Scrabble al ser sustraido a un decimal de
   * Scrabble.
   */
  SNumbers subtractFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la resta entre un numero de Scrabble al ser sustraido a un binario de
   * Scrabble.
   */
  SNumbers subtractBin(scrabbleBinary sB);
  /** Devuelve como es la resta entre dos numeros de Scrabble. */
  SNumbers subtract(SNumbers s);
  /**
   * Devuelve como es la multiplicacion entre un entero de Scrabble al multiplicarsele un numero de
   * Scrabble.
   */
  SNumbers multiplyInt(scrabbleInt sI);
  /**
   * Devuelve como es la multiplicacion entre un decimal de Scrabble al multiplicarsele un numero de
   * Scrabble.
   */
  SNumbers multiplyFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la multiplicacion entre un binario de Scrabble al multiplicarsele un numero de
   * Scrabble.
   */
  SNumbers multiplyBin(scrabbleBinary sB);
  /** Devuelve como es la multiplicacion entre dos numeros de Scrabble. */
  SNumbers multiply(SNumbers s);
  /**
   * Devuelve como es la division entre un entero de Scrabble ser dividido por un numero de
   * Scrabble.
   */
  SNumbers divideInt(scrabbleInt sI);
  /**
   * Devuelve como es la division entre un decimal de Scrabble ser dividido por un numero de
   * Scrabble.
   */
  SNumbers divideFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la division entre un binario de Scrabble ser dividido por un numero de
   * Scrabble.
   */
  SNumbers divideBin(scrabbleBinary sB);
  /** Devuelve como es la division entre dos numeros de Scrabble. */
  SNumbers divide(SNumbers s);
}
