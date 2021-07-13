package cl.uchile.dcc.scrabble.gui.Scrabbles;

import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleBinary;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleFloat;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleInt;
import cl.uchile.dcc.scrabble.gui.operaciones.Hojas;

public interface SNumbers extends ScrType{
  /**
   * Transforma un numero de Scrabble(CLase que implemente la interfaz) a un Binario de Scrabble.
   */
  @Override
  scrabbleBinary toScrBin();
  /** Transforma un numero de Scrabble(clase que implemente la interfaz) a un Entero de Scrabble. */
  @Override
  scrabbleInt toScrInt();
  /**
   * Transforma un numero de Scrabble(clase que implemente la interfaz) a un decimal de Scrabble.
   */
  @Override
  scrabbleFloat toScrFloat();
  /**
   * Devuelve como es la suma entre un numero de Scrabble al ser sumado con un entero de Scrabble.
   */
  @Override
  SNumbers addInt(scrabbleInt sI);
  /**
   * Devuelve como es la suma entre un numero de Scrabble al ser sumado con un decimal de Scrabble.
   */
  @Override
  SNumbers addFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la suma entre un numero de Scrabble al ser sumado con un binario de Scrabble.
   */
  @Override
  SNumbers addBin(scrabbleBinary sB);
  /** Devuelve como es la suma entre dos numero de Scrabble. */
  @Override
  SNumbers add(Hojas s);
  /**
   * Devuelve como es la resta entre un numero de Scrabble al ser sustraido a un entero de Scrabble.
   */
  @Override
  SNumbers subtractInt(scrabbleInt sI);
  /**
   * Devuelve como es la resta entre un numero de Scrabble al ser sustraido a un decimal de
   * Scrabble.
   */
  @Override
  SNumbers subtractFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la resta entre un numero de Scrabble al ser sustraido a un binario de
   * Scrabble.
   */
  @Override
  SNumbers subtractBin(scrabbleBinary sB);
  /** Devuelve como es la resta entre dos numeros de Scrabble. */
  @Override
  SNumbers subtract(Hojas s);
  /**
   * Devuelve como es la multiplicacion entre un entero de Scrabble al multiplicarsele un numero de
   * Scrabble.
   */
  @Override
  SNumbers multiplyInt(scrabbleInt sI);
  /**
   * Devuelve como es la multiplicacion entre un decimal de Scrabble al multiplicarsele un numero de
   * Scrabble.
   */
  @Override
  SNumbers multiplyFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la multiplicacion entre un binario de Scrabble al multiplicarsele un numero de
   * Scrabble.
   */
  @Override
  SNumbers multiplyBin(scrabbleBinary sB);
  /** Devuelve como es la multiplicacion entre dos numeros de Scrabble. */
  @Override
  SNumbers multiply(Hojas s);
  /**
   * Devuelve como es la division entre un entero de Scrabble ser dividido por un numero de
   * Scrabble.
   */
  @Override
  SNumbers divideInt(scrabbleInt sI);
  /**
   * Devuelve como es la division entre un decimal de Scrabble ser dividido por un numero de
   * Scrabble.
   */
  @Override
  SNumbers divideFloat(scrabbleFloat sF);
  /**
   * Devuelve como es la division entre un binario de Scrabble ser dividido por un numero de
   * Scrabble.
   */
  @Override
  SNumbers divideBin(scrabbleBinary sB);
  /** Devuelve como es la division entre dos numeros de Scrabble. */
  @Override
  SNumbers divide(Hojas s);
}
