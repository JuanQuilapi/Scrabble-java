package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;

public class Or implements Operacion{
    private final Operacion addend1;
    private final Operacion addend2;

    public Or(Operacion addend1, Operacion addend2){
        this.addend1 = addend1;
        this.addend2 = addend2;
    }
    @Override
    public Hojas eval() {
        return addend1.eval().or(addend2.eval());
    }
}
