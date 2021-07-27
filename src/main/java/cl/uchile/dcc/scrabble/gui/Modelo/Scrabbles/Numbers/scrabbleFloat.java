package cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles.Numbers;

import cl.uchile.dcc.scrabble.gui.Factory.SFloatFac;
import cl.uchile.dcc.scrabble.gui.Factory.SStringFac;
import cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles.SNumbers;
import cl.uchile.dcc.scrabble.gui.Modelo.Scrabbles.scrabbleString;
import cl.uchile.dcc.scrabble.gui.operaciones.Hojas;

import java.util.Objects;
/**
 * Clase que representa a los decimales(Floats) del programa Scrabble, con sus transformaciones y
 * operaciones correspondientes y retorna null, a las transformaciones y operaciones que no puede
 * realizar.
 */
public class scrabbleFloat implements SNumbers {
  private final Double sFloat;
  /** Constructor que inicializa los Floats de Scrabble, recibe un double nativo de java. */
  public scrabbleFloat(Double sFloat) {
    this.sFloat = sFloat;
  }
  /**
   * Obtiene el decimal de clase.
   *
   * @return el decimal almacenado en la clase.
   */
  public Double getsFloat() {
    return sFloat;
  }

  @Override
  public String toString() {
    return String.valueOf(this.sFloat);
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleString toScrString() {
    return SStringFac.make(this.toString());
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleFloat toScrFloat() {
    return SFloatFac.make(this.sFloat);
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleInt toScrInt() {
    return null;
  }
  /** {@inheritDoc} */
  @Override
  public scrabbleBinary toScrBin() {
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat addInt(scrabbleInt sI) {
    return SFloatFac.make(sI.toScrFloat().getsFloat() + this.sFloat);
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat addFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() + this.sFloat);
  }
  /**
   * {@inheritDoc}
   *
   * @return null, operacion invalida.
   */
  @Override
  public scrabbleFloat addBin(scrabbleBinary sB) {
    return null;
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat add(Hojas s) {
    return (scrabbleFloat) s.addFloat(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat subtractInt(scrabbleInt sI) {
    return SFloatFac.make(sI.toScrFloat().getsFloat() - this.sFloat);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat subtractFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() - this.sFloat);
  }
  /**
   * {@inheritDoc}
   *
   * @return null, operacion invalida.
   */
  @Override
  public scrabbleFloat subtractBin(scrabbleBinary sB) {
    return null;
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat subtract(Hojas s) {
    return (scrabbleFloat) s.subtractFloat(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat multiplyInt(scrabbleInt sI) {
    return SFloatFac.make(sI.toScrFloat().getsFloat() * this.sFloat);
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat multiplyFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() * this.sFloat);
  }
  /**
   * {@inheritDoc}
   *
   * @return null, operacion invalida.
   */
  @Override
  public scrabbleFloat multiplyBin(scrabbleBinary sB) {
    return null;
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat multiply(Hojas s) {
    return (scrabbleFloat) s.multiplyFloat(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat divideInt(scrabbleInt sI) {
    return SFloatFac.make(sI.toScrFloat().getsFloat() / this.sFloat);
  }
  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat divideFloat(scrabbleFloat sF) {
    return SFloatFac.make(sF.getsFloat() / this.sFloat);
  }

  @Override
  public SNumbers divideBin(scrabbleBinary sB) {
    return null;
  }

  /**
   * {@inheritDoc}
   *
   * @return un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat divide(Hojas s) {
    return (scrabbleFloat) s.divideFloat(this);
  }

  /** Sobreescribe el metodo equals y hashCode de java, para poder realizar los test. */
  @Override
  public int hashCode() {
    return Objects.hash(sFloat);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof scrabbleFloat) {
      var o = (scrabbleFloat) obj;
      return o.sFloat.equals(this.sFloat);
    }
    return false;
  }
}
