package cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers;

import cl.uchile.dcc.scrabble.gui.Scrabbles.*;
import cl.uchile.dcc.scrabble.gui.operaciones.Hojas;

import java.util.Arrays;
import java.util.Objects;
/**
 * Clase que representa a los numeros binarios del programa Scrabble, con sus transformaciones y
 * operaciones correspondientes y retorna null, a las transformaciones y operaciones que no puede
 * realizar.
 */
public class scrabbleBinary implements SNumbers, SLogical {
  private final String sBinary;
  /**
   * Constructor que inicializa los Binarios de Scrabble, recibe un Strings con 1's y 0's y verifica
   * que esta bien escritos.
   */
  public scrabbleBinary(String sBinary) {
    this.sBinary = sBinary;
  }
  /**
   * Obtiene el binario de clase.
   *
   * @return el binario almacenado en la clase.
   */
  public String getsBinary() {
    return sBinary;
  }

  @Override
  public String toString() {
    return String.valueOf(this.sBinary);
  }

  @Override
  public scrabbleString toScrString() {
    return new scrabbleString(this.sBinary);
  }

  @Override
  public scrabbleFloat toScrFloat() {
    return this.toScrInt().toScrFloat();
  }

  /**
   * Revisa un bit de un binario de Scrabble.
   *
   * @param bit un char especifico que compone un String binario.
   * @return el valor entero de un bit de un binario de Scrabble.
   */
  private int bitToInt(char bit) {
    return bit == '0' ? 0 : 1;
  }

  /**
   * Transforma un string binario positivo en un entero positivo.
   *
   * @param binary binario en forma de string.
   * @return el valor entero que representa el string binario.
   */
  private int positiveBinToInt(String binary) {
    int w = 0;
    for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
      w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
    }
    return w;
  }

  /**
   * Transforma un string binario negativo en un entero negativo.
   *
   * @param binary binario en forma de string.
   * @return el valor entero que representa el string binario.
   */
  private int negativeBinaryToInt(String binary) {
    var arrayBin = binary.toCharArray();
    for (int j = arrayBin.length - 1; j >= 0; j--) {
      if (arrayBin[j] == '1') {
        arrayBin[j] = '0';
        break;
      } else {
        arrayBin[j] = '1';
      }
    }
    for (int i = 0; i < arrayBin.length; i++) {
      if (arrayBin[i] == '1') {
        arrayBin[i] = '0';
      } else {
        arrayBin[i] = '1';
      }
    }
    return -positiveBinToInt(String.valueOf(arrayBin));
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt toScrInt() {
    if (bitToInt(this.sBinary.charAt(0)) == 0) {
      return new scrabbleInt(positiveBinToInt(sBinary));
    } else {
      return new scrabbleInt(negativeBinaryToInt(sBinary));
    }
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary toScrBin() {
    return new scrabbleBinary(this.sBinary);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt addInt(scrabbleInt sI) {
    int i = this.toScrInt().getsInt();
    i += sI.getsInt();
    return new scrabbleInt(i);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat addFloat(scrabbleFloat sF) {
    return new scrabbleFloat(sF.getsFloat() + this.toScrInt().getsInt());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary addBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt();
    iB += this.toScrInt().getsInt();
    return new scrabbleInt(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers add(Hojas s) {
    return s.addBin(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt subtractInt(scrabbleInt sI) {
    int i = sI.getsInt() - this.toScrInt().getsInt();
    return new scrabbleInt(i);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat subtractFloat(scrabbleFloat sF) {
    return new scrabbleFloat(sF.getsFloat() - this.toScrFloat().getsFloat());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary subtractBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt() - this.toScrInt().getsInt();
    return new scrabbleInt(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers subtract(Hojas s) {
    return (SNumbers) s.subtractBin(this);
  }

  @Override
  public scrabbleInt multiplyInt(scrabbleInt sI) {
    int i = sI.getsInt() * this.toScrInt().getsInt();
    return new scrabbleInt(i);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat multiplyFloat(scrabbleFloat sF) {
    return new scrabbleFloat(sF.getsFloat() * this.toScrFloat().getsFloat());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary multiplyBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt() * this.toScrInt().getsInt();
    return new scrabbleInt(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers multiply(Hojas s) {
    return (SNumbers) s.multiplyBin(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un entero de Scrabble.
   */
  @Override
  public scrabbleInt divideInt(scrabbleInt sI) {
    int i = sI.getsInt() / this.toScrInt().getsInt();
    return new scrabbleInt(i);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un decimal de Scrabble.
   */
  @Override
  public scrabbleFloat divideFloat(scrabbleFloat sF) {
    return new scrabbleFloat(sF.getsFloat() / this.toScrFloat().getsFloat());
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary divideBin(scrabbleBinary sB) {
    int iB = sB.toScrInt().getsInt() / this.toScrInt().getsInt();
    return new scrabbleInt(iB).toScrBin();
  }
  /**
   * {@inheritDoc}
   *
   * @return Un numero que implemente la interfaz SNumbers(int, float o binario)
   */
  @Override
  public SNumbers divide(Hojas s) {
    return (SNumbers) s.divideBin(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary neg() {
    var arr = this.sBinary.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '0') {
        arr[i] = '1';
      } else {
        arr[i] = '0';
      }
    }
    return new scrabbleBinary(String.valueOf(arr));
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary andBool(scrabbleBoolean lB) {
    if (lB.getBool()) {
      return this.toScrBin();
    } else {
      var arr = this.sBinary.toCharArray();
      Arrays.fill(arr, '0');
      return new scrabbleBinary(String.valueOf(arr));
    }
  }

  /**
   * Deja 2 strings del mismo largo(del largo del string de mayor longitud), agregando 0's al inicio
   * si en binario es positivo, y 1's si el binario es negativo.
   *
   * @param s1 string binario.
   * @param s2 string binario.
   * @return un arreglo con ambos strings, con el mismo largo.
   */
  private String[] emparejar(String s1, String s2) {
    StringBuilder b1 = new StringBuilder(s1);
    int l1 = b1.length();
    StringBuilder b2 = new StringBuilder(s2);
    int l2 = b2.length();
    if (Math.abs(l1 - l2) > 0) {
      if (l1 > l2) {
        for (int i = l2; i < l1; i++) {
          b2.insert(0, b2.charAt(0));
        }
      } else {
        for (int i = l1; i < l2; i++) {
          b1.insert(0, b1.charAt(0));
        }
      }
    }
    return new String[] {String.valueOf(b1), String.valueOf(b2)};
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary andBinary(scrabbleBinary lB) {
    String[] bins = emparejar(this.sBinary, lB.getsBinary());
    String b1 = bins[0];
    String b2 = bins[1];
    var arr = b1.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (b1.charAt(i) == '1' && b2.charAt(i) == '1') {
        arr[i] = '1';
      } else {
        arr[i] = '0';
      }
    }
    return new scrabbleBinary(String.valueOf(arr));
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary and(Hojas l) {
    return (scrabbleBinary) l.andBinary(this);
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary orBool(scrabbleBoolean lB) {
    if (lB.getBool()) {
      var arr = this.sBinary.toCharArray();
      Arrays.fill(arr, '1');
      return new scrabbleBinary(String.valueOf(arr));
    } else {
      return this.toScrBin();
    }
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary orBinary(scrabbleBinary lB) {
    String[] bins = emparejar(this.sBinary, lB.getsBinary());
    String b1 = bins[0];
    String b2 = bins[1];
    var arr = b1.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (b1.charAt(i) == '1' || b2.charAt(i) == '1') {
        arr[i] = '1';
      }
    }
    return new scrabbleBinary(String.valueOf(arr));
  }
  /**
   * {@inheritDoc}
   *
   * @return Un binario de Scrabble.
   */
  @Override
  public scrabbleBinary or(Hojas l) {
    return (scrabbleBinary) l.orBinary(this);
  }


  @Override
  public int hashCode() {
    return Objects.hash(sBinary);
  }
  /** Sobreescribe el metodo equals y hashCode de java, para poder realizar los test. */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof scrabbleBinary) {
      var o = (scrabbleBinary) obj;
      return o.sBinary.equals(this.sBinary);
    }
    return false;
  }
}
