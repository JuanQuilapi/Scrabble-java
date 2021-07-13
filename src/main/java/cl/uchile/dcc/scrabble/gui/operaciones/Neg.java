package cl.uchile.dcc.scrabble.gui.operaciones;

import java.util.Objects;

public class Neg implements Operacion{
    private final Operacion addend1;

    public Neg(Operacion addend1){
        this.addend1 = addend1;
    }
    @Override
    public Hojas eval() {
        return addend1.eval().neg();
    }
}
