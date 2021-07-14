package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;
/**
 * Clase que agrega un nodo de Transformacion a binario al AST, tiene 1 hijo que es otra operacion.
 */
public class ToBin implements Operacion {
  private final Operacion addend1;
  /** Constructor de clase, recibe 1 hijo que deben ser una operacion del arbol. */
  public ToBin(Operacion addend1) {
    this.addend1 = addend1;
  }
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().toScrBin();
  }
}