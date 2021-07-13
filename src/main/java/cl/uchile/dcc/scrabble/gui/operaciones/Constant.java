package cl.uchile.dcc.scrabble.gui.operaciones;


import java.util.Objects;

public class Constant implements Operacion{
    private final Hojas addend1;
    public Constant(Hojas addend1){
        this.addend1 = addend1;
    }

    @Override
    public Hojas eval() {
        return this.addend1;
    }
}
