package cl.uchile.dcc.scrabble.gui.Factory;

import cl.uchile.dcc.scrabble.gui.Scrabbles.scrabbleString;

import java.util.Hashtable;

public class SStringFac{
    private static final Hashtable<String, scrabbleString> hashtable0 = new Hashtable<>();

    public static scrabbleString make(String s) {
        scrabbleString scrS = hashtable0.get(s);
        if(scrS != null){
            return scrS;
        }
        else {
            scrS = new scrabbleString(s);
            hashtable0.put(s,scrS);
        }
        return scrS;
    }
}
