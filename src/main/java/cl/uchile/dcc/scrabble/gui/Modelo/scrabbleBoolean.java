package cl.uchile.dcc.scrabble.gui.Modelo;

import cl.uchile.dcc.scrabble.gui.Controller.Factory.SBinFac;
import cl.uchile.dcc.scrabble.gui.Controller.Factory.SBoolFac;
import cl.uchile.dcc.scrabble.gui.Controller.Factory.SStringFac;
import cl.uchile.dcc.scrabble.gui.Modelo.Numbers.scrabbleBinary;
import cl.uchile.dcc.scrabble.gui.Controller.operaciones.Hojas;

import java.util.Arrays;
import java.util.Objects;
/**
 * Clase que representa a los Booleanos del programa Scrabble, con sus transformaciones y
 * operaciones correspondientes.
 */
public class scrabbleBoolean implements SLogical {
  private final boolean Bool;
  /** Constructor que inicializa los Booleanos de Scrabble, recibe un boolean nativo de java. */
  public scrabbleBoolean(boolean Bool) {
    this.Bool = Bool;
  }
  /**
   * Obtiene el booleano de clase.
   *
   * @return el booleano almacenado en la clase.
   */
  public boolean getBool() {
    return Bool;
  }

  @Override
  public String toString() {
    return String.valueOf(this.Bool);
  }

  @Override
  public scrabbleString toScrString() {
    return SStringFac.make(this.toString());
  }
  /**
   * Transforma un booleano de Scrabble a un Booleano de Scrabble.
   *
   * @return un nuevo booleano de Scrabble,copia del anterior.
   */
  public scrabbleBoolean toScrBool() {
    return SBoolFac.make(this.Bool);
  }
  /**
   * {@inheritDoc}
   *
   * @return la negacion del booleano actual.
   */
  @Override
  public scrabbleBoolean neg() {
    return SBoolFac.make(!this.Bool);
  }
  /**
   * {@inheritDoc}
   *
   * @return un booleano de Scrabble.
   */
  @Override
  public scrabbleBoolean andBool(scrabbleBoolean lB) {
    return SBoolFac.make(lB.getBool() && this.Bool);
  }
  /**
   * {@inheritDoc}
   *
   * @return un binario de Scrabble.
   */
  @Override
  public scrabbleBinary andBinary(scrabbleBinary lB) {
    if (this.Bool) {
      return lB.toScrBin();
    } else {
      var arr = lB.getsBinary().toCharArray();
      Arrays.fill(arr, '0');
      return SBinFac.make(String.valueOf(arr));
    }
  }
  /**
   * {@inheritDoc}
   *
   * @return Una clase que implemente la interfaz SLogical(boolean o binario)
   */
  @Override
  public SLogical and(Hojas l) {
    return l.andBool(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un booleano de Scrabble.
   */
  @Override
  public scrabbleBoolean orBool(scrabbleBoolean lB) {
    return SBoolFac.make(lB.getBool() || this.Bool);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary orBinary(scrabbleBinary lB) {
    if (this.Bool) {
      var arr = lB.getsBinary().toCharArray();
      Arrays.fill(arr, '1');
      return SBinFac.make(String.valueOf(arr));
    } else {
      return lB.toScrBin();
    }
  }
  /**
   * {@inheritDoc}
   *
   * @return Una clase que implemente la interfaz SLogical(boolean o binario)
   */
  @Override
  public SLogical or(Hojas l) {
    return l.orBool(this);
  }
  /** Sobreescribe el metodo equals y hashCode de java, para poder realizar los test. */
  @Override
  public int hashCode() {
    return Objects.hash(Bool);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof scrabbleBoolean) {
      var o = (scrabbleBoolean) obj;
      return o.Bool == (this.Bool);
    }
    return false;
  }
}
