package cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers;

import cl.uchile.dcc.scrabble.gui.Factory.SBinFac;
import cl.uchile.dcc.scrabble.gui.Factory.SFloatFac;
import cl.uchile.dcc.scrabble.gui.Factory.SIntFac;
import cl.uchile.dcc.scrabble.gui.Factory.SStringFac;
import cl.uchile.dcc.scrabble.gui.Scrabbles.SLogical;
import cl.uchile.dcc.scrabble.gui.Scrabbles.SNumbers;
import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleBoolean;
import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleString;
import cl.uchile.dcc.scrabble.gui.operaciones.Hojas;

import java.util.Objects;
/**
 * Clase que representa a los numeros enteros del programa Scrabble, con sus transformaciones y
 * operaciones correspondientes y retorna null, a las transformaciones y operaciones que no puede
 * realizar.
 */
public class scrabbleInt implements SNumbers{
  private final Integer sInt;
  /** Constructor que inicializa los enteros de Scrabble, recibe un entero nativo de java. */
  public scrabbleInt(Integer sInt) {
    this.sInt = sInt;
  }
  /**
   * Obtiene el entero de clase.
   *
   * @return el entero almacenado en la clase.
   */
  public Integer getsInt() {
    return sInt;
  }

  @Override
  public String toString() {
    return String.valueOf(this.sInt);
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleString toScrString() {
    return SStringFac.make(this.toString());
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleFloat toScrFloat() {
    return SFloatFac.make(this.sInt.doubleValue());
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleInt toScrInt() {
    return SIntFac.make(this.sInt);
  }
  /** realiza la transformacion de un binario a su negativo binario mediante el complemento de 2. */
  private String complementOf2(String b) {
    var arrayBin = b.toCharArray();
    for (int i = 0; i < arrayBin.length; i++) {
      if (arrayBin[i] == '1') {
        arrayBin[i] = '0';
      } else {
        arrayBin[i] = '1';
      }
    }
    for (int j = arrayBin.length - 1; j >= 0; j--) {
      if (arrayBin[j] == '0') {
        arrayBin[j] = '1';
        b = String.valueOf(arrayBin);
        return b;
      } else {
        arrayBin[j] = '0';
      }
    }
    return b;
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleBinary toScrBin() {
    int abso = Math.abs(sInt);
    String b = '0' + Integer.toBinaryString(abso);
    if (sInt < 0) {
      b = complementOf2(b);
      return SBinFac.make(b);
    }
    return SBinFac.make(b);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt addInt(scrabbleInt sI) {
    return SIntFac.make(sI.getsInt() + this.sInt);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat addFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() + this.toScrFloat().getsFloat());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary addBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt();
    iB += getsInt();
    return SIntFac.make(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers add(Hojas s) { return s.addInt(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt subtractInt(scrabbleInt sI) {
    return SIntFac.make(sI.getsInt() - this.sInt);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat subtractFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() - this.toScrFloat().getsFloat());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary subtractBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt();
    iB -= getsInt();
    return SIntFac.make(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers subtract(Hojas s) {
    return s.subtractInt(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt multiplyInt(scrabbleInt sI) {
    return SIntFac.make(sI.getsInt() * this.sInt);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat multiplyFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() * this.toScrFloat().getsFloat());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary multiplyBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt();
    iB *= getsInt();
    return SIntFac.make(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers multiply(Hojas s) {
    return s.multiplyInt(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt divideInt(scrabbleInt sI) {
    return SIntFac.make(sI.getsInt() / this.sInt);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat divideFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() / this.toScrFloat().getsFloat());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary divideBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt();
    iB /= getsInt();
    return SIntFac.make(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers divide(Hojas s) {
    return (SNumbers) s.divideInt(this);
  }

  /** Sobreescribe el metodo equals y hashCode de java, para poder realizar los test. */
  @Override
  public int hashCode() {
    return Objects.hash(sInt);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof scrabbleInt) {
      var o = (scrabbleInt) obj;
      return o.sInt.equals(this.sInt);
    }
    return false;
  }
}
