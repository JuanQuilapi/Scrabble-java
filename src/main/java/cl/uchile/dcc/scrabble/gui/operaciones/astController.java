package cl.uchile.dcc.scrabble.gui.operaciones;

public class astController {
  private static OperacionBi resultado=null;

  public static void setCopa(OperacionBi op){
    resultado = op;
  }

  public static void setNodo11(OperacionBi op){
    resultado.setAddend1(op);
  }
  public static void setNodo11(OperacionUni op){
    resultado.setAddend1(op);
  }
  public static void setNodo11(Constant c){
    resultado.setAddend1(c);
  }
  public static void setNodo12(OperacionBi op){
    resultado.setAddend2(op);
  }
  public static void setNodo12(OperacionUni op){
    resultado.setAddend2(op);
  }
  public static void setNodo21(Constant c){
    resultado.getAddend1();
  }
  public static void setNodo22(Constant c){
    resultado.getAddend1();
  }
  public static void setNodo23(Constant c){
    resultado.getAddend2();
  }
  public static void setNodo24(Constant c){
    resultado.getAddend2();
  }



}
