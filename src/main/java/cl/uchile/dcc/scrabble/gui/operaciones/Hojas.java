package cl.uchile.dcc.scrabble.gui.operaciones;

import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleBinary;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleFloat;
import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleInt;
import cl.uchile.dcc.scrabble.gui.Scrabbles.SLogical;
import cl.uchile.dcc.scrabble.gui.Scrabbles.SNumbers;
import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleBoolean;
import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleString;

public interface Hojas {
    default scrabbleInt toScrInt(){return null;}

    default scrabbleBinary toScrBin(){return null;}

    default scrabbleFloat toScrFloat(){return null;}

    default scrabbleBoolean toScrBool(){return null;}

    default scrabbleString toScrString(){return null;}

    default SLogical neg(){ return null; }

    default Hojas add(Hojas s){return null;}

    default SNumbers addInt(scrabbleInt scrabbleInt){return null;}

    default SNumbers addFloat(scrabbleFloat scrabbleFloat){return null;}

    default SNumbers addBin(scrabbleBinary scrabbleBinary){return null;}

    default SNumbers subtract(Hojas s){return null;}

    default SNumbers subtractInt(scrabbleInt scrabbleInt){return null;}

    default SNumbers subtractFloat(scrabbleFloat scrabbleFloat){return null;}

    default SNumbers subtractBin(scrabbleBinary scrabbleBinary){return null;}

    default SNumbers multiply(Hojas s){return null;}

    default SNumbers multiplyInt(scrabbleInt scrabbleInt){return null;}

    default SNumbers multiplyFloat(scrabbleFloat scrabbleFloat){return null;}

    default SNumbers multiplyBin(scrabbleBinary scrabbleBinary){return null;}

    default SNumbers divide(Hojas s){return null;}

    default SNumbers divideInt(scrabbleInt scrabbleInt){return null;}

    default SNumbers divideFloat(scrabbleFloat scrabbleFloat){return null;}

    default SNumbers divideBin(scrabbleBinary scrabbleBinary){return null;}

    default SLogical andBool(scrabbleBoolean lB){return null;}

    default SLogical andBinary(scrabbleBinary lB){return null;}

    default SLogical and(Hojas l){return null;}

    default SLogical orBool(scrabbleBoolean lB){return null;}

    default SLogical orBinary(scrabbleBinary lB){return null;}

    default SLogical or(Hojas l){return null;}
}
