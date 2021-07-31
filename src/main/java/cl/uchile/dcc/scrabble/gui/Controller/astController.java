package cl.uchile.dcc.scrabble.gui.Controller;

import cl.uchile.dcc.scrabble.gui.Controller.Factory.SIntFac;
import cl.uchile.dcc.scrabble.gui.Controller.operaciones.Add;
import cl.uchile.dcc.scrabble.gui.Controller.operaciones.Constant;
import cl.uchile.dcc.scrabble.gui.Controller.operaciones.Hojas;
import cl.uchile.dcc.scrabble.gui.Controller.operaciones.Operacion;
import java.util.ArrayList;

public class astController {
  private static Operacion resultado=null;
  private static final ArrayList<Operacion> OpList= new ArrayList<>();

  public static void AddOpScr(String s){
    if(s.equals("Add")){
      OpList.add(new Add());
    }
    if(s.equals("Null")){
      OpList.add(null);
    }
    
  }
  public static void AddConst(String tipo,String valor){
    if(tipo.equals("Entero")){
      OpList.add(new Constant(SIntFac.make(Integer.valueOf(valor))));
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

  public static String printAst(){
    return OpList.toString();
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
