package cl.uchile.dcc.scrabble.gui.operaciones;

/** Clase que agrega un nodo de suma al AST, tiene 2 hijos que son otras operaciones. */
public class Add implements OperacionBi {
  private Operacion addend1;
  private Operacion addend2;

  @Override
  public Operacion getAddend1() {
    return addend1;
  }
  @Override
  public Operacion getAddend2() {
    return addend2;
  }
  @Override
  public void setAddend1(Operacion addend1) {
    this.addend1 = addend1;
  }
  @Override
  public void setAddend2(Operacion addend2) {
    this.addend2 = addend2;
  }

  /** Constructor de clase, recibe 2 hijos que deben operaciones del arbol. */
  public Add(Operacion addend1, Operacion addend2) {
    this.addend1 = addend1;
    this.addend2 = addend2;
  }

  public Add(){
    this.addend1 = null;
    this.addend2 = null;
  }


  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().add(addend2.eval());
  }
}
