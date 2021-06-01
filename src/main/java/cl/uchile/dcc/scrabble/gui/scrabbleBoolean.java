package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
/**
 * Clase que representa a los Booleanos del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleBoolean implements ITipos {
    private final boolean Bool;
    /**
     * Constructor que inicializa los Booleanos de Scrabble, recibe un boolean nativo de java.
     */
    public scrabbleBoolean(boolean Bool){
        this.Bool = Bool;
    }
    /**
     * Sobreescribe el metodo toString de java, para poder visualizar los test.
     */
    @Override
    public String toString() {
        return String.valueOf(this.Bool);
    }
    /**
     *  Transforma un Booleano de Scrabble a un String de Scrabble.
     */
    @Override
    public scrabbleString toScrString(){
        return new scrabbleString(this.toString());
    }
    /**
     *  Transforma un Booleano de Scrabble a un Booleano de Scrabble.
     */
    @Override
    public scrabbleBoolean toScrBool(){
        return new scrabbleBoolean(this.Bool);
    }
    /**
     *  Transformacion un Booleano de Scrabble a un Float de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleFloat toScrFloat(){return null;}
    /**
     *  Transformacion un Booleano de Scrabble a un Entero de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleInt toScrInt(){return null;}
    /**
     *  Transformacion un Booleano de Scrabble a un Binario de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleBinary toScrBin(){return null;}
    /**
     * Sobreescribe el metodo equals y hashCode de java, para poder realizar los test.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Bool);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof scrabbleBoolean) {
            var o =(scrabbleBoolean) obj;
            return o.Bool==(this.Bool);
        }
        return false;
    }
}
