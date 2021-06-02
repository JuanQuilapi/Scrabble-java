package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
/**
 * Clase que representa a los decimales(Floats) del programa Scrabble, con sus transformaciones y operaciones correspondientes
 * y retorna null, a las transformaciones y operaciones que no puede realizar.
 */
public class scrabbleFloat implements SStrings,SNumbers{
    private final Double sFloat;

    /**
     * Constructor que inicializa los Floats de Scrabble, recibe un double nativo de java.
     */
    public scrabbleFloat(Double sFloat){
        this.sFloat = sFloat;
    }
    /**
     * Obtiene el decimal de clase.
     *
     * @return el decimal almacenado en la clase.
     */
    public Double getsFloat() {
        return sFloat;
    }

    @Override
    public String toString() {
        return String.valueOf(this.sFloat);
    }

    @Override
    public scrabbleString toScrString(){
        return new scrabbleString(this.toString());
    }

    @Override
    public scrabbleFloat toScrFloat(){
        return new scrabbleFloat(this.sFloat);
    }

    @Override
    public scrabbleInt toScrInt(){return null;}

    @Override
    public scrabbleBinary toScrBin(){return null;}

    @Override
    public scrabbleFloat addInt(scrabbleInt sI){
        return new scrabbleFloat(sI.toScrFloat().getsFloat()+this.sFloat);
    }
    @Override
    public scrabbleFloat addFloat(scrabbleFloat sF){
        return new scrabbleFloat(sF.getsFloat()+this.sFloat);
    }
    @Override
    public scrabbleFloat addBin(scrabbleBinary sB){
        return null;
    }
    @Override
    public scrabbleFloat add(SNumbers s){
        return (scrabbleFloat) s.addFloat(this);
    }
    @Override
    public scrabbleFloat subtractInt(scrabbleInt sI){
        return new scrabbleFloat(sI.toScrFloat().getsFloat() - this.sFloat);
    }
    @Override
    public SNumbers subtractFloat(scrabbleFloat sF) {
        return new scrabbleFloat(sF.getsFloat() - this.sFloat);
    }
    @Override
    public scrabbleFloat subtractBin(scrabbleBinary sB){
        return null;
    }
    @Override
    public scrabbleFloat subtract(SNumbers s){
        return (scrabbleFloat) s.subtractFloat(this);
    }
    @Override
    public scrabbleFloat multiplyInt(scrabbleInt sI){
        return new scrabbleFloat(sI.toScrFloat().getsFloat() * this.sFloat);
    }
    @Override
    public scrabbleFloat multiplyFloat(scrabbleFloat sF) {
        return new scrabbleFloat(sF.getsFloat() * this.sFloat);
    }
    @Override
    public scrabbleFloat multiplyBin(scrabbleBinary sB){
        return null;
    }
    @Override
    public scrabbleFloat multiply(SNumbers s){
        return (scrabbleFloat) s.multiplyFloat(this);
    }
    @Override
    public scrabbleFloat divideInt(scrabbleInt sI){
        return new scrabbleFloat( sI.toScrFloat().getsFloat() / this.sFloat);
    }
    @Override
    public scrabbleFloat divideFloat(scrabbleFloat sF) {
        return new scrabbleFloat(sF.getsFloat() / this.sFloat);
    }
    @Override
    public scrabbleFloat divideBin(scrabbleBinary sB){
        return null;
    }
    @Override
    public scrabbleFloat divide(SNumbers s) {
        return (scrabbleFloat) s.divideFloat(this);
    }

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
