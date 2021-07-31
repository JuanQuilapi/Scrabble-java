package cl.uchile.dcc.scrabble.gui.Controller.operaciones;

/**
 * Clase que agrega un nodo de Transformacion a decimal al AST, tiene 1 hijo que es otra operacion.
 */
public class ToFloat implements Operacion {
  private Operacion addend1;
  /** Constructor de clase, recibe 1 hijo que deben ser una operacion del arbol. */
  public ToFloat(Operacion addend1) {
    this.addend1 = addend1;
  }
  public ToFloat(){this.addend1 = null;}
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().toScrFloat();
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
