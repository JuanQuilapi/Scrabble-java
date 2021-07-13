package cl.uchile.dcc.scrabble.gui.Factory;



import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleFloat;

import java.util.Hashtable;

public class SFloatFac {
    private static final Hashtable<Double, scrabbleFloat> hashtable2 = new Hashtable<>();

    public static scrabbleFloat make(Double f) {
        scrabbleFloat scrF = hashtable2.get(f);
        if(scrF != null){
            return scrF;
        }
        else {
            scrF = new scrabbleFloat(f);
            hashtable2.put(f,scrF);
        }
        return scrF;
    }
}
