package cl.uchile.dcc.scrabble.gui;

public interface SLogical {
    SLogical neg();
    SLogical andBool(scrabbleBoolean lB);
    SLogical andBinary(scrabbleBinary lB);
    SLogical and(SLogical l);
    SLogical orBool(scrabbleBoolean lB);
    SLogical orBinary(scrabbleBinary lB);
    SLogical or(SLogical l);
}
