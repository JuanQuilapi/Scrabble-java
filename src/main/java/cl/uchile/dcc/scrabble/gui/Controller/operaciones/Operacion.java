package cl.uchile.dcc.scrabble.gui.Controller.operaciones;

/** Interfaz de las operaciones que se pueden agregar al AST. */
public interface Operacion {

  /**
   * Metodo que evalua el valor de un nodo del arbol, calculando su valor recorriendo a todos sus
   * hijos
   */
  Hojas eval();
  void agregar(Operacion op);
  Boolean isBin();
}
