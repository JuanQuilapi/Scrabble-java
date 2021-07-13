package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;

public class Div implements Operacion{
    private final Operacion addend1;
    private final Operacion addend2;

    public Div(Operacion addend1, Operacion addend2){
        this.addend1 = addend1;
        this.addend2 = addend2;
    }
    @Override
    public Hojas eval() {
        return addend1.eval().divide(addend2.eval());
    }
}
