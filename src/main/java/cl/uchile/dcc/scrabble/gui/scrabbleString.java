package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
/**
 * Clase que representa a los Strings del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleString implements ITipos{
    private final String str;

    /**
     * Constructor que inicializa los strings de Scrabble, recibe un string nativo de java.
     */
    public scrabbleString(String str){
        this.str = str;
    }
    /**
     * Sobreescribe el metodo toString de java, para poder visualizar los test.
     */
    @Override
    public String toString() {
        return this.str;
    }
    /**
     *  Transforma un string de Scrabble a un String de Scrabble.
     */
    @Override
    public scrabbleString toScrString(){return new scrabbleString(this.str);}
    /**
     * Transformacion de String de Scrabble a Booleano de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleBoolean toScrBool(){ return null;}
    /**
     * Transformacion de String de Scrabble a FLoat de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleFloat toScrFloat(){return null;}
    /**
     * Transformacion de String de Scrabble a Entero de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleInt toScrInt(){return null;}
    /**
     * Transformacion de String de Scrabble a Binario de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleBinary toScrBin(){return null;}
    /**
     * Sobreescribe el metodo equals y hashCode de java, para poder realizar los test.
     */
    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof scrabbleString) {
          var o =(scrabbleString) obj;
          return o.str.equals(this.str);
        }
        return false;
    }
}
