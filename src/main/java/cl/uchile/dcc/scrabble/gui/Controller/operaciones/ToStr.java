package cl.uchile.dcc.scrabble.gui.Controller.operaciones;

/**
 * Clase que agrega un nodo de Transformacion a String al AST, tiene 1 hijo que es otra operacion.
 */
public class ToStr implements Operacion {
  private Operacion addend1;
  /** Constructor de clase, recibe 1 hijo que deben ser una operacion del arbol. */
  public ToStr(Operacion addend1) {
    this.addend1 = addend1;
  }
  public ToStr(){this.addend1 = null;}
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().toScrString();
  }

  @Override
  public void agregar(Operacion op) {
    if(this.addend1 == null){
      this.addend1 = op;
    }
  }

  @Override
  public Boolean isBin() {
    return false;
  }
}
