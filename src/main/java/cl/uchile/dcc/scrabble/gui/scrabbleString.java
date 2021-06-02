package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
/**
 * Clase que representa a los Strings del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleString implements SStrings{
    private final String str;
    /**
     * Constructor que inicializa los Strings de Scrabble, recibe un string nativo de java.
     */
    public scrabbleString(String str){
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }

    @Override
    public scrabbleString toScrString(){return new scrabbleString(this.str);}
    /**
     * Concatena un string de Scrabble con cualquier otro tipo que implementa la interfaz SStrings.
     *
     * @return un nuevo string de Scrabble con la concatenacion del string y el valor en forma de string de la otra
     * clase.
     */
    public scrabbleString add(SStrings s){
        return new scrabbleString(this.str+s.toString());
    }

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
