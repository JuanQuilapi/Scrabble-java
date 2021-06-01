package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
/**
 * Clase que representa a los decimales(Floats) del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleFloat implements ITipos,SNumbers{
    private final Double sFloat;

    public Double getsFloat() {
        return sFloat;
    }
    /**
     * Constructor que inicializa los Floats de Scrabble, recibe un double nativo de java.
     */
    public scrabbleFloat(Double sFloat){
        this.sFloat = sFloat;
    }
    /**
     * Sobreescribe el metodo toString de java, para poder visualizar los test.
     */
    @Override
    public String toString() {
        return String.valueOf(this.sFloat);
    }
    /**
     *  Transforma un Float de Scrabble a un String de Scrabble.
     */
    @Override
    public scrabbleString toScrString(){
        return new scrabbleString(this.toString());
    }
    /**
     *  Transformacion un Float de Scrabble a un Booleano de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleBoolean toScrBool(){return null;}
    /**
     *  Transforma un Float de Scrabble a un Float de Scrabble.
     */
    @Override
    public scrabbleFloat toScrFloat(){
        return new scrabbleFloat(this.sFloat);
    }
    /**
     *  Transformacion un Float de Scrabble a un Entero de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleInt toScrInt(){return null;}
    /**
     *  Transformacion de  un Float de Scrabble a un Binario de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleBinary toScrBin(){return null;}
    //@Override
    /*public scrabbleFloat add(SNumbers10 s){
        return new scrabbleFloat(this.sFloat+s.toScrFloat().getsFloat());
    }*/
    /**
     * Sobreescribe el metodo equals y hashCode de java, para poder realizar los test.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sFloat);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof scrabbleFloat) {
            var o =(scrabbleFloat) obj;
            return o.sFloat.equals(this.sFloat);
        }
        return false;
    }


}
