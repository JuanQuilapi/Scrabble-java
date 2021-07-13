package cl.uchile.dcc.scrabble.gui.Factory;

import cl.uchile.dcc.scrabble.gui.Scrabbles.Numbers.scrabbleBinary;

import java.util.Hashtable;

public class SBinFac {
    private static final Hashtable<String, scrabbleBinary> hashtable4 = new Hashtable<>();

    public static scrabbleBinary make(String b) {
        scrabbleBinary scrBin = hashtable4.get(b);
        if(scrBin != null){
            return scrBin;
        }
        else {
            scrBin = new scrabbleBinary(b);
            hashtable4.put(b,scrBin);
        }
        return scrBin;
    }
}
