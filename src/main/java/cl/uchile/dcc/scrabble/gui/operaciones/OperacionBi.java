package cl.uchile.dcc.scrabble.gui.operaciones;

public interface OperacionBi extends Operacion{
  public Operacion getAddend1();
  public Operacion getAddend2();
  public void setAddend1(Operacion addend1);
  public void setAddend2(Operacion addend2);

}
