package cl.uchile.dcc.scrabble.gui.operaciones;

/**
 * Clase que agrega un nodo de Transformacion a Entero al AST, tiene 1 hijo que es otra operacion.
 */
public class ToInt implements OperacionUni {
  private Operacion addend1;
  /** Constructor de clase, recibe 1 hijo que deben ser una operacion del arbol. */
  public ToInt(Operacion addend1) {
    this.addend1 = addend1;
  }

  public ToInt(){
    this.addend1 = null;
  }
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().toScrInt();
  }

  @Override
  public Operacion getAddend1() {
    return this.addend1;
  }

  @Override
  public void setAddend1(Operacion addend1) {
    this.addend1 = addend1;
  }
}
