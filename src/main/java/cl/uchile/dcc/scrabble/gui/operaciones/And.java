package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;
/**
 * Clase que agrega un nodo de conjuncion logica al AST, tiene 2 hijos que son otras operaciones.
 */
public class And implements Operacion {
  private final Operacion addend1;
  private final Operacion addend2;
  /** Constructor de clase, recibe 2 hijos que deben operaciones del arbol. */
  public And(Operacion addend1, Operacion addend2) {
    this.addend1 = addend1;
    this.addend2 = addend2;
  }
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().and(addend2.eval());
  }
}
