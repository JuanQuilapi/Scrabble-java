package cl.uchile.dcc.scrabble.gui.Controller;

import cl.uchile.dcc.scrabble.gui.Controller.Factory.*;
import cl.uchile.dcc.scrabble.gui.Controller.operaciones.*;
import java.util.ArrayList;

public class astController {
  private static Operacion resultado = null;
  private static final ArrayList<Operacion> OpList = new ArrayList<>();

  public static void AddOpScr(String s){
    if(s.equals("Add")){
      OpList.add(new Add());
    }
    if(s.equals("Null")){
      OpList.add(null);
    }
    if(s.equals("And")){
      OpList.add(new And());
    }
    if(s.equals("Div")){
      OpList.add(new Div());
    }
    if(s.equals("Mult")){
      OpList.add(new Mult());
    }
    if(s.equals("Neg")){
      OpList.add(new Neg());
    }
    if(s.equals("Or")){
      OpList.add(new Or());
    }
    if(s.equals("Sub")){
      OpList.add(new Sub());
    }
    if(s.equals("ToBin")){
      OpList.add(new ToBin());
    }
    if(s.equals("ToBool")){
      OpList.add(new ToBool());
    }
    if(s.equals("ToFloat")){
      OpList.add(new ToFloat());
    }
    if(s.equals("ToInt")){
      OpList.add(new ToInt());
    }
    if(s.equals("ToStr")){
      OpList.add(new ToStr());
    }
  }
  public static void AddConst(String tipo,String valor){
    if(tipo.equals("Entero")){
      OpList.add(new Constant(SIntFac.make(Integer.valueOf(valor))));
    }
    if(tipo.equals("Booleano")){
      OpList.add(new Constant(SBoolFac.make(Boolean.valueOf(valor))));
    }
    if(tipo.equals("Decimal")){
      OpList.add(new Constant(SFloatFac.make(Double.valueOf(valor))));
    }
    if(tipo.equals("Binario")){
      OpList.add(new Constant(SBinFac.make(valor)));
    }
    if(tipo.equals("String")){
      OpList.add(new Constant(SStringFac.make(valor)));
    }
  }

  private static void armarAst(){
    if (OpList.size() >= 2) {
      for (int i = 0; i < OpList.size()/2; i++) {
        Operacion nodo = OpList.get(i);
        if(nodo != null){
          nodo.agregar(OpList.get(i*2 + 1));
          if(nodo.isBin()){
            nodo.agregar(OpList.get(i*2 + 2));
          }
        }
      }
    }
    resultado = OpList.get(0);
  }

  public static void reset(){
    resultado = null;
    OpList.clear();
  }
  public static Hojas getResultado(){
    armarAst();
    return resultado.eval();
  }
}
