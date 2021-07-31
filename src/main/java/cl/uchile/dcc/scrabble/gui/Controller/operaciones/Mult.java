package cl.uchile.dcc.scrabble.gui.Controller.operaciones;

/** Clase que agrega un nodo de multiplicacion al AST, tiene 2 hijos que son otras operaciones. */
public class Mult implements Operacion {
  private Operacion addend1;
  private Operacion addend2;
  /** Constructor de clase, recibe 2 hijos que deben operaciones del arbol. */
  public Mult(Operacion addend1, Operacion addend2) {
    this.addend1 = addend1;
    this.addend2 = addend2;
  }
  public Mult(){
    this.addend1 = null;
    this.addend2 = null;
  }
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().multiply(addend2.eval());
  }

  @Override
  public void agregar(Operacion op) {
    if(this.addend1 == null){
      this.addend1 = op;
    }
    else{
      if(this.addend2 == null){
        this.addend2 = op;
      }
    }
  }

  @Override
  public Boolean isBin() {
    return true;
  }
}
