package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;
/** Clase que agrega un nodo de division al AST, tiene 2 hijos que son otras operaciones. */
public class Div implements Operacion{
    private final Operacion addend1;
    private final Operacion addend2;
  /** Constructor de clase, recibe 2 hijos que deben operaciones del arbol. */
  public Div(Operacion addend1, Operacion addend2) {
        this.addend1 = addend1;
        this.addend2 = addend2;
    }
    /** {@inheritDoc} */
    @Override
    public Hojas eval() {
        return addend1.eval().divide(addend2.eval());
    }
}
