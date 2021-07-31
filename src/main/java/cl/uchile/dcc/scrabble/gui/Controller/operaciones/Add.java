package cl.uchile.dcc.scrabble.gui.Controller.operaciones;

/** Clase que agrega un nodo de suma al AST, tiene 2 hijos que son otras operaciones. */
public class Add implements Operacion {
  private Operacion addend1;
  private Operacion addend2;

  /** Constructor de clase, recibe 2 hijos que deben operaciones del arbol. */
  public Add(Operacion addend1, Operacion addend2) {
    this.addend1 = addend1;
    this.addend2 = addend2;
  }

  public Add(){
    this.addend1 = null;
    this.addend2 = null;
  }

  @Override
  public void agregar(Operacion op){
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

  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return addend1.eval().add(addend2.eval());
  }
}
