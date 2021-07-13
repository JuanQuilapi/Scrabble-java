package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;

public class Sub implements Operacion {
    private final Operacion addend1;
    private final Operacion addend2;

    public Sub(Operacion addend1, Operacion addend2){
        this.addend1 = addend1;
        this.addend2 = addend2;
    }
    @Override
    public Hojas eval() {
        return addend1.eval().subtract(addend2.eval());
    }
}
