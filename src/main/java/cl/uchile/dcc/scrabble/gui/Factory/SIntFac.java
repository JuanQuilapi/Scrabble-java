package cl.uchile.dcc.scrabble.gui.Factory;


import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleInt;

import java.util.Hashtable;

public class SIntFac {
    private static final Hashtable<Integer, scrabbleInt> hashtable1 = new Hashtable<>();

    public static scrabbleInt make(Integer i) {
        scrabbleInt scrI = hashtable1.get(i);
        if(scrI != null){
            return scrI;
        }
        else {
            scrI = new scrabbleInt(i);
            hashtable1.put(i,scrI);
        }
        return scrI;
    }
}
