package cl.uchile.dcc.scrabble.gui.operaciones;

/**
 * Clase que agrega un nodo de Transformacion a String al AST, tiene 1 hijo que es otra operacion.
 */
public class ToStr implements Operacion {
  private final Operacion addend1;
  /** Constructor de clase, recibe 1 hijo que deben ser una operacion del arbol. */
  public ToStr(Operacion addend1) {
    this.addend1 = addend1;
  }
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().toScrString();
  }
}
