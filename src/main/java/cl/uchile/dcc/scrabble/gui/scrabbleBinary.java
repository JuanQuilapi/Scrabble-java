package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
/**
 * Clase que representa a los numeros binarios del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleBinary implements ITipos{
    private final String sBinary;
    /**
     * Constructor que inicializa los Binarios de Scrabble, recibe un Strings con 1's y 0's y verifica que esta bien escritos(?).(CHEECK)
     */
    public scrabbleBinary(String sBinary){
        this.sBinary = sBinary;
    }
    /**
     * Sobreescribe el metodo toString de java, para poder visualizar los test.
     */
    @Override
    public String toString() {
        return String.valueOf(this.sBinary);
    }
    /**
     *  Transforma un Binario de Scrabble a un String de Scrabble.
     */
    @Override
    public scrabbleString toScrString(){return new scrabbleString(this.sBinary);}
    /**
     *  Transformacion  de un Binario de Scrabble a un Booleano de Scrabble no es valida, retorna null.
     */
    @Override
    public scrabbleBoolean toScrBool(){return null;}
    /**
     *  Transforma un Entero de Scrabble a un Float de Scrabble.
     */
    @Override
    public scrabbleFloat toScrFloat(){
        return this.toScrInt().toScrFloat();
    }

    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }
    private int negativeBinaryToInt(String binary) {
        var arrayBin= binary.toCharArray();
        for(int j = arrayBin.length-1;j>=0;j--){
            if(arrayBin[j]=='1'){
                arrayBin[j] = '0';
                break;
            }
            else{ arrayBin[j]='1'; }
        }
        for (int i = 0; i < arrayBin.length; i++) {
            if (arrayBin[i] == '1') {
                arrayBin[i] = '0';
            } else {
                arrayBin[i] = '1';
            }
        }
        return -positiveBinToInt(String.valueOf(arrayBin));
    }
    /**
     *  Transforma un Binario de Scrabble a un Entero de Scrabble.
     */
    @Override
    public scrabbleInt toScrInt() {
        if (bitToInt(this.sBinary.charAt(0)) == 0) {
            return new scrabbleInt(positiveBinToInt(sBinary));
        } else {
            return new scrabbleInt(negativeBinaryToInt(sBinary));
        }
    }
    /**
     *  Transforma un Binario de Scrabble a un Binario de Scrabble, se retorna a si mismo.
     */
    @Override
    public scrabbleBinary toScrBin(){ return new scrabbleBinary(this.sBinary); }
    /**
     * Sobreescribe el metodo equals y hashCode de java, para poder realizar los test.
     */
    @Override
    public int hashCode() {
        return Objects.hash(sBinary);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof scrabbleBinary) {
            var o =(scrabbleBinary) obj;
            return o.sBinary.equals(this.sBinary);
        }
        return false;
    }
}
