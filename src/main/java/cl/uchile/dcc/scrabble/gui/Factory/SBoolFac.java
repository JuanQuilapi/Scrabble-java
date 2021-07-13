package cl.uchile.dcc.scrabble.gui.Factory;



import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleBoolean;

import java.util.Hashtable;

public class SBoolFac {
    private static final Hashtable<Boolean, scrabbleBoolean> hashtable3 = new Hashtable<>();

    public static scrabbleBoolean make(Boolean b) {
        scrabbleBoolean scrBool = hashtable3.get(b);
        if(scrBool != null){
            return scrBool;
        }
        else {
            scrBool = new scrabbleBoolean(b);
            hashtable3.put(b,scrBool);
        }
        return scrBool;
    }
}
