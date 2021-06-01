package cl.uchile.dcc.scrabble.gui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
/**
 * Clase que representa a los numeros enteros del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleInt implements ITipos,SNumbers{
    private final Integer sInt;
    /**
     * Constructor que inicializa los enteros de Scrabble, recibe un entero nativo de java.
     */
    public scrabbleInt(Integer sInt) {
        this.sInt = sInt;
    }
    /**
     * Sobreescribe el metodo toString de java, para poder visualizar los test.
     */
    @Override
    public String toString() {
        return String.valueOf(this.sInt);
    }
    /**
     *  Transforma un Entero de Scrabble a un String de Scrabble.
     */
    @Override
    public scrabbleString toScrString(){
        return new scrabbleString(this.toString());
    }
    /**
     *  Transformacion  de un Entero de Scrabble a un Booleano de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleBoolean toScrBool(){return null;}
    /**
     *  Transforma un Entero de Scrabble a un Float de Scrabble.
     */
    @Override
    public scrabbleFloat toScrFloat(){
        return new scrabbleFloat(this.sInt.doubleValue());
    }
    /**
     *  Transforma un Entero de Scrabble a un Entero de Scrabble.
     */
    @Override
    public scrabbleInt toScrInt(){
        return new scrabbleInt(this.sInt);
    }
    /**
     *  realiza la transformacion de un binario a su negativo binario mediante el complemento de 2.
     */
    private String complementOf2(String b){
        var arrayBin= b.toCharArray();
        for (int i = 0; i < arrayBin.length; i++) {
            if (arrayBin[i] == '1') {
                arrayBin[i] = '0';
            } else {
                arrayBin[i] = '1';
            }
        }
       for(int j = arrayBin.length-1;j>=0;j--){
           if(arrayBin[j]=='0'){
               arrayBin[j] = '1';
               b = String.valueOf(arrayBin);
               return b;
           }
           else{ arrayBin[j]='0'; }
       }
    return b;
    }
    /**
     *  Transforma un Entero de Scrabble a un Binario de Scrabble.
     */
    @Override
    public scrabbleBinary toScrBin(){
    int abso = Math.abs(sInt);
    String b = '0'+Integer.toBinaryString(abso);
    if(sInt<0){
        b = complementOf2(b);
        return new scrabbleBinary(b);
    }
    return new scrabbleBinary(b);
    }

    /**
     * Sobreescribe el metodo equals y hashCode de java, para poder realizar los test.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sInt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof scrabbleInt) {
            var o =(scrabbleInt) obj;
            return o.sInt.equals(this.sInt);
        }
        return false;
    }


}
