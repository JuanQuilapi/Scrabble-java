package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;
/** Clase que agrega un nodo de Constante al AST, tiene un hijo que son las hojas de los arboles. */
public class Constant implements Operacion {
  private Hojas addend1;
  /** Constructor de clase, recibe 1 hijo que debe ser una hoja del AST(tipos de Scrabble). */
  public Constant(Hojas addend1) {
    this.addend1 = addend1;
  }

  public Constant(){
    this.addend1 = null;
  }

  public Hojas getAddend1() {
    return addend1;
  }

  public void setAddend1(Hojas addend1) {
    this.addend1 = addend1;
  }
  /** {@inheritDoc} */
  @Override
  public Hojas eval() {
    return this.addend1;
  }
}
