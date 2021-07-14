package cl.uchile.dcc.scrabble.gui.operaciones;

/** Clase que agrega un nodo de suma al AST, tiene 2 hijos que son otras operaciones. */
public class Add implements Operacion {
  private final Operacion addend1;
  private final Operacion addend2;

  /** Constructor de clase, recibe 2 hijos que deben operaciones del arbol. */
  public Add(Operacion addend1, Operacion addend2) {
    this.addend1 = addend1;
    this.addend2 = addend2;
  }
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().add(addend2.eval());
  }
}
