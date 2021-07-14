package cl.uchile.dcc.scrabble.gui.operaciones;

import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleBinary;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleFloat;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleInt;
import cl.uchile.dcc.scrabble.gui.Scrabbles.SLogical;
import cl.uchile.dcc.scrabble.gui.Scrabbles.SNumbers;
import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleBoolean;
import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleString;

/**
 * clase que contiene todas las operaciones posibles entre las hojas del arbol, todos estos metodos
 * retornan null por defecto, reflejando que esa es una operacion invalida para ese tipo.
 */
public interface Hojas {
  /**
   * Metodo que transforma el tipo de Scrabble en un entero, realizable solo por binarios y enteros
   */
  default scrabbleInt toScrInt() {
    return null;
  }
  /**
   * Metodo que transforma el tipo de Scrabble en un Binario, realizable solo por Binarios y
   * enteros.
   */
  default scrabbleBinary toScrBin() {
    return null;
  }
  /** Metodo que transforma el tipo de Scrabble en un Float, realizable solo por SNumbers. */
  default scrabbleFloat toScrFloat() {
    return null;
  }
  /**
   * Metodo que transforma el tipo de Scrabble en un Booleano, realizable solo por los mismos
   * Booleanos.
   */
  default scrabbleBoolean toScrBool() {
    return null;
  }
  /**
   * Metodo que transforma el tipo de Scrabble en un String, realizable solo por todos los tipos de
   * Scrabble.
   */
  default scrabbleString toScrString() {
    return null;
  }
  /** Metodo que retorna la negacion del tipo de Scrabble , realizable solo por los Slogical. */
  default SLogical neg() {
    return null;
  }
  /**
   * Metodo que retorna la adicion de 2 tipos de Scrabble , realizable solo entre Snumbers, y entre
   * Strings con cualquier tipo.
   */
  default Hojas add(Hojas s) {
    return null;
  }
  /**
   * Metodo que retorna la adicion entre un tipo de Scrabble y un Entero de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers addInt(scrabbleInt scrabbleInt) {
    return null;
  }
  /**
   * Metodo que retorna la adicion entre un tipo de Scrabble y un Decimal de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers addFloat(scrabbleFloat scrabbleFloat) {
    return null;
  }
  /**
   * Metodo que retorna la adicion entre un tipo de Scrabble y un Binario de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers addBin(scrabbleBinary scrabbleBinary) {
    return null;
  }
  /** Metodo que retorna la Resta de 2 tipos de Scrabble , realizable solo entre Snumbers. */
  default SNumbers subtract(Hojas s) {
    return null;
  }
  /**
   * Metodo que retorna la resta entre un tipo de Scrabble y un Entero de Scrabble , realizable solo
   * entre Snumbers.
   */
  default SNumbers subtractInt(scrabbleInt scrabbleInt) {
    return null;
  }
  /**
   * Metodo que retorna la resta entre un tipo de Scrabble y un Decimal de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers subtractFloat(scrabbleFloat scrabbleFloat) {
    return null;
  }
  /**
   * Metodo que retorna la resta entre un tipo de Scrabble y un Binario de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers subtractBin(scrabbleBinary scrabbleBinary) {
    return null;
  }
  /**
   * Metodo que retorna la multiplicacion de 2 tipos de Scrabble , realizable solo entre Snumbers.
   */
  default SNumbers multiply(Hojas s) {
    return null;
  }
  /**
   * Metodo que retorna la multiplicacion entre un tipo de Scrabble y un Entero de Scrabble ,
   * realizable solo entre Snumbers.
   */
  default SNumbers multiplyInt(scrabbleInt scrabbleInt) {
    return null;
  }
  /**
   * Metodo que retorna la multiplicacion entre un tipo de Scrabble y un Decimal de Scrabble ,
   * realizable solo entre Snumbers.
   */
  default SNumbers multiplyFloat(scrabbleFloat scrabbleFloat) {
    return null;
  }
  /**
   * Metodo que retorna la multiplicacion entre un tipo de Scrabble y un Binario de Scrabble ,
   * realizable solo entre Snumbers.
   */
  default SNumbers multiplyBin(scrabbleBinary scrabbleBinary) {
    return null;
  }
  /** Metodo que retorna la division de 2 tipos de Scrabble , realizable solo entre Snumbers. */
  default SNumbers divide(Hojas s) {
    return null;
  }
  /**
   * Metodo que retorna la division entre un tipo de Scrabble y un Entero de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers divideInt(scrabbleInt scrabbleInt) {
    return null;
  }
  /**
   * Metodo que retorna la division entre un tipo de Scrabble y un Decimal de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers divideFloat(scrabbleFloat scrabbleFloat) {
    return null;
  }
  /**
   * Metodo que retorna la division entre un tipo de Scrabble y un Binario de Scrabble , realizable
   * solo entre Snumbers.
   */
  default SNumbers divideBin(scrabbleBinary scrabbleBinary) {
    return null;
  }
  /** Metodo que retorna la conjuncion de 2 tipos de Scrabble , realizable solo entre SLogical. */
  default SLogical and(Hojas l) {
    return null;
  }
  /**
   * Metodo que retorna la conjuncion entre un tipo de Scrabble y un Booleano , realizable solo
   * entre SLogical.
   */
  default SLogical andBool(scrabbleBoolean lB) {
    return null;
  }
  /**
   * Metodo que retorna la conjuncion entre un tipo de Scrabble y un Binario , realizable solo entre
   * SLogical.
   */
  default SLogical andBinary(scrabbleBinary lB) {
    return null;
  }
  /** Metodo que retorna la Disyuncion de 2 tipos de Scrabble , realizable solo entre SLogical. */
  default SLogical or(Hojas l) {
    return null;
  }
  /**
   * Metodo que retorna la disyuncion entre un tipo de Scrabble y un Booleano , realizable solo
   * entre SLogical.
   */
  default SLogical orBool(scrabbleBoolean lB) {
    return null;
  }
  /**
   * Metodo que retorna la disyuncion entre un tipo de Scrabble y un Binario , realizable solo entre
   * SLogical.
   */
  default SLogical orBinary(scrabbleBinary lB) {
    return null;
  }
}
