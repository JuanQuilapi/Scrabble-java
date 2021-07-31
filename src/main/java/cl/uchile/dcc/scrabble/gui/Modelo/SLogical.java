package cl.uchile.dcc.scrabble.gui.Modelo;

import cl.uchile.dcc.scrabble.gui.Modelo.Numbers.scrabbleBinary;
import cl.uchile.dcc.scrabble.gui.Controller.operaciones.Hojas;

public interface SLogical extends ScrType{
  /** Aplica la negacion unitaria del Scrabble correspondiente. */
  @Override
  SLogical neg();
  /** Aplica la conjuncion entre un Booleano de Scrabble y una clase que usa la logica. */
  @Override
  SLogical andBool(scrabbleBoolean lB);
  /** Aplica la conjuncion entre un Binario de Scrabble y una clase que usa la logica. */
  @Override
  SLogical andBinary(scrabbleBinary lB);
  /** Aplica la conjuncion entre 2 clases de Scrabble que usen la logica. */
  @Override
  SLogical and(Hojas l);
  /** Aplica la disyuncion entre un Booleano de Scrabble y una clase que usa la logica. */
  @Override
  SLogical orBool(scrabbleBoolean lB);
  /** Aplica la disyuncion entre un Binario de Scrabble y una clase que usa la logica. */
  @Override
  SLogical orBinary(scrabbleBinary lB);
  /** Aplica la disyuncion entre 2 clases de Scrabble que usen la logica. */
  @Override
  SLogical or(Hojas l);
}
