package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;
/** Clase que agrega un nodo de resta al AST, tiene 2 hijos que son otras operaciones. */
public class Sub implements OperacionBi {
  private Operacion addend1;
  private Operacion addend2;

  @Override
  public void setAddend1(Operacion addend1) {
    this.addend1 = addend1;
  }
  @Override
  public void setAddend2(Operacion addend2) {
    this.addend2 = addend2;
  }
  @Override
  public Operacion getAddend1() {
    return addend1;
  }
  @Override
  public Operacion getAddend2() {
    return addend2;
  }

  /** Constructor de clase, recibe 2 hijos que deben operaciones del arbol. */
  public Sub(Operacion addend1, Operacion addend2) {
    this.addend1 = addend1;
    this.addend2 = addend2;
  }

  public Sub(){
    this.addend1 = null;
    this.addend2 = null;
  }

  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().subtract(addend2.eval());
  }
}
