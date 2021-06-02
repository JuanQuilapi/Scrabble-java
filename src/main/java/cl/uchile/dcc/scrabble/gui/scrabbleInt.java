package cl.uchile.dcc.scrabble.gui;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
/**
 * Clase que representa a los numeros enteros del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleInt implements SStrings,SNumbers{
    private final Integer sInt;
    /**
     * Constructor que inicializa los enteros de Scrabble, recibe un entero nativo de java.
     */
    public scrabbleInt(Integer sInt) {
        this.sInt = sInt;
    }
    /**
     * Obtiene el entero de clase.
     *
     * @return el entero almacenado en la clase.
     */
    public Integer getsInt() {
        return sInt;
    }

    @Override
    public String toString() {
        return String.valueOf(this.sInt);
    }

    @Override
    public scrabbleString toScrString(){
        return new scrabbleString(this.toString());
    }

    @Override
    public scrabbleFloat toScrFloat(){
        return new scrabbleFloat(this.sInt.doubleValue());
    }

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
    @Override
    public scrabbleInt addInt(scrabbleInt sI){
        return new scrabbleInt(sI.getsInt()+this.sInt);
    }

    @Override
    public scrabbleFloat addFloat(scrabbleFloat sF){
        return new scrabbleFloat(sF.getsFloat()+this.toScrFloat().getsFloat());
    }

    @Override
    public scrabbleBinary addBin(scrabbleBinary sB){
        int iB = sB.toScrInt().getsInt();
        iB += getsInt();
        return new scrabbleInt(iB).toScrBin();
    }

    @Override
    public SNumbers add(SNumbers s){
        return s.addInt(this);
    }

    @Override
    public scrabbleInt subtractInt(scrabbleInt sI){
        return new scrabbleInt(sI.getsInt() - this.sInt);
    }

    @Override
    public scrabbleFloat subtractFloat(scrabbleFloat sF) {
        return new scrabbleFloat(sF.getsFloat() - this.toScrFloat().getsFloat());
    }

    @Override
    public scrabbleBinary subtractBin(scrabbleBinary sB){
        int iB = sB.toScrInt().getsInt();
        iB -= getsInt();
        return new scrabbleInt(iB).toScrBin();
    }

    @Override
    public SNumbers subtract(SNumbers s){
        return s.subtractInt(this);
    }

    @Override
    public scrabbleInt multiplyInt(scrabbleInt sI){
        return new scrabbleInt(sI.getsInt() * this.sInt);
    }

    @Override
    public scrabbleFloat multiplyFloat(scrabbleFloat sF) {
        return new scrabbleFloat(sF.getsFloat() * this.toScrFloat().getsFloat());
    }

    @Override
    public scrabbleBinary multiplyBin(scrabbleBinary sB){
        int iB = sB.toScrInt().getsInt();
        iB *= getsInt();
        return new scrabbleInt(iB).toScrBin();
    }

    @Override
    public SNumbers multiply(SNumbers s){
        return s.multiplyInt(this);
    }

    @Override
    public scrabbleInt divideInt(scrabbleInt sI){
        return new scrabbleInt(sI.getsInt() / this.sInt);
    }

    @Override
    public scrabbleFloat divideFloat(scrabbleFloat sF) {
        return new scrabbleFloat(sF.getsFloat() / this.toScrFloat().getsFloat());
    }

    @Override
    public scrabbleBinary divideBin(scrabbleBinary sB){
        int iB = sB.toScrInt().getsInt();
        iB /= getsInt();
        return new scrabbleInt(iB).toScrBin();
    }

    @Override
    public SNumbers divide(SNumbers s) {
        return s.divideInt(this);
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
