package cl.uchile.dcc.scrabble.gui;

public interface SLogical {
    /**
     * Aplica la negacion unitaria del Scrabble correspondiente.
     */
    SLogical neg();

    /**
     * Aplica la conjuncion entre un Booleano de Scrabble y una clase que usa la logica.
     */
    SLogical andBool(scrabbleBoolean lB);
    /**
     * Aplica la conjuncion entre un Binario de Scrabble y una clase que usa la logica.
     */
    SLogical andBinary(scrabbleBinary lB);
    /**
     * Aplica la conjuncion entre 2 clases de Scrabble que usen la logica.
     */
    SLogical and(SLogical l);
    /**
     * Aplica la disyuncion entre un Booleano de Scrabble y una clase que usa la logica.
     */
    SLogical orBool(scrabbleBoolean lB);
    /**
     * Aplica la disyuncion entre un Binario de Scrabble y una clase que usa la logica.
     */
    SLogical orBinary(scrabbleBinary lB);
    /**
     * Aplica la disyuncion entre 2 clases de Scrabble que usen la logica.
     */
    SLogical or(SLogical l);
}
